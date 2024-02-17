package org.example;

public class Book {
    private static int id_gen = 1;
    private int id;
    private String genre;
    private String book_name;
    private int price;

    public Book() {
        id = id_gen++;
    }

    public Book(int id, String book_name, String genre, int price) {
        this();
        setBook_name(book_name);
        setGenre(genre);
        setPrice(price);
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + ": " +
                book_name + " (" +
                genre + ") for" +
                price + " tenge.";
    }
}