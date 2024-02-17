package org.example;

public class Order {
    private User user;
    private Book book;
    private int id;
    private static int id_gen = 1;

    public Order() {
        id = id_gen++;
    }

    public Order(int id, User user, Book book) {
        this();
        this.user = user;
        this.book = book;
        this.id = id_gen++;
    }
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public int getOrderId() {
        return id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", book=" + book +
                ", id=" + id +
                '}';
    }
}