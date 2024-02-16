package org.example;
import org.example.models.Book;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String conString = "jdbc:postgresql://localhost:5432/simpledb";
        Connection con = null;
        ArrayList<Book> books = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(conString, "postgres", "0000");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name,genre,price from Book");

            while(rs.next()) {
                String name = rs.getString("name");
                String genre = rs.getString("genre");
                int price = rs.getInt("price");
                Book book = new Book(name , genre , price);
            }
        }catch (SQLException e){
            System.out.println("Connection error: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Driver error: " + e.getMessage());
        }

        for (Book book : books) {
            System.out.println(book);
        }

    }
}