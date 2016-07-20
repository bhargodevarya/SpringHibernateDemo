package com.example.model;

import java.io.Serializable;

/**
 * Created by hadoop on 20/7/16.
 */
public class Book implements Serializable {

    private Float price;
    private String title;

    public Book() {
    }

    public Book(Float price, String title) {
        this.price = price;
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
