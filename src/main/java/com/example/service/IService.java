package com.example.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 433132 on 7/1/2016.
 */
public interface IService<T> {

    void create(T t);
    void update(T t);
    void delete(T t);
    T get(T t);
}
