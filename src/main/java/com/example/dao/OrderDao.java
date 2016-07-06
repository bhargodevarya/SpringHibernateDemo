package com.example.dao;

import com.example.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 27/6/16.
 */
@Repository
@Transactional
public class OrderDao extends AbstractDao<Order> {

    public void saveOrder(Order order) {
        save(order);
    }
}
