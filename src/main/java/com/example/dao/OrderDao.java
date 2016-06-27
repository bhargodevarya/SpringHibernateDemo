package com.example.dao;

import com.example.model.Order;

/**
 * Created by hadoop on 27/6/16.
 */
public class OrderDao extends AbstractDao<Order> {

    public void saveOrder(Order order) {
        save(order);
    }
}
