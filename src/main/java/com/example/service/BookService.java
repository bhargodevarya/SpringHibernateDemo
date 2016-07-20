package com.example.service;

import com.example.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by hadoop on 20/7/16.
 */
@Component
public class BookService {

    @Cacheable("default")
    public Book getBookByTitle() {
        Book book = new Book(200.5F,"mybook-hibernate");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book get() {
        return null;
    }
}
