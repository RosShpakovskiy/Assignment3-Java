package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String genre;
    private String name;
    private int price;

    @Override
    public String toString() {
        return "Book{" +
                "genre='" + genre + '\'' +
                ", bookName='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
