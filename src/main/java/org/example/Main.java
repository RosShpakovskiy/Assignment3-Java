package org.example;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String conString = "jdbc:postgresql://localhost:5432/simpledb";
        Connection con = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(conString, "postgres", "0304");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name, address, book, price FROM orders");

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String book = rs.getString("book");
                int price = rs.getInt("price");
                Order order = new Order(id, name, address, book, price);
                orders.add(order);
            }
        }catch (SQLException e){
            System.out.println("Connection error: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Driver error: " + e.getMessage());
        }

        for (Order order : orders) {
            System.out.println(order);
        }

    }
}