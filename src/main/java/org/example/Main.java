package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static User registeredUser() {
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to online bookstore");

        System.out.println("Please, you need to register. Enter your name: ");
        String name = read.nextLine();
        System.out.println("Now enter your surname: ");
        String surname = read.nextLine();
        System.out.println("Enter your full address: ");
        String address = read.nextLine();

        User user = new User(name, surname, address);
        return user;
    }

    public static void main(String[] args) {
        String conString = "jdbc:postgresql://localhost:5432/simpledb";
        ArrayList<Book> books = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(conString, "postgres", "0304");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name, genre, price from book");

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String genre = rs.getString("genre");
                int price = rs.getInt("price");
                Book book = new Book(id, name, genre, price);
                books.add(book);
            }

            PreparedStatement st = con.prepareStatement("INSERT INTO users (name, surname, address) VALUES (?, ?, ?)");
            User user = registeredUser();
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getAddress());
            st.executeUpdate();
            st.close();

            while (true) {
                Scanner reader = new Scanner(System.in);
                System.out.println("Choose a book you want: ");

                for (Book book : books) {
                    System.out.println(book);
                }

                System.out.println("Tip: print an id of a book you want");
                int n = reader.nextInt();
                Book cart = books.get(n-1);

                System.out.println("The total price is " + cart.getPrice() + " tenge. Do you want to order this book? (Y/N): ");
                char a = reader.next().charAt(0);
                if (Objects.equals(a, 'Y') || Objects.equals(a, 'y')) {
                    System.out.println("Thank you for your order!");

                    PreparedStatement stm = con.prepareStatement("INSERT INTO orders (name, surname, address, book, genre, price) VALUES (?, ?, ?, ?, ?, ?)");
                    stm.setString(1, user.getName());
                    stm.setString(2, user.getSurname());
                    stm.setString(3, user.getAddress());
                    stm.setString(4, cart.getBook_name());
                    stm.setString(5, cart.getGenre());
                    stm.setInt(6, cart.getPrice());
                    stm.executeUpdate();
                    stm.close();

                    break;
                }

                else {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Do you want to continue the shopping? (Y/N): ");
                    char b = reader.next().charAt(0);
                    sc.close();
                    if (Objects.equals(b, 'N') || Objects.equals(b, 'n')) {
                        break;
                    }
                }
            }

        }catch (SQLException e){
            System.out.println("Connection error: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Driver error: " + e.getMessage());
        }

    }

}