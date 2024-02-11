package org.example;

public class Order {
    private static int id_gen = 1;
    private String name;
    private String address;
    private String book;
    private int price;
    private int id;

    public Order() {
        id = id_gen++;
    }

    public Order(int id, String name, String address, String book, int price) {
        this();
        setName(name);
        setAddress(address);
        setBook(book);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order with " +
                "id " + id +
                ": [name: " + name +
                ", address: " + address +
                ", book = " + book +
                ", price=" + price +
                ']';
    }
}
