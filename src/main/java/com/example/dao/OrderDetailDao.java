package com.example.dao;

import com.example.model.OrderDetail;

/**
 * Created by hadoop on 27/6/16.
 */
public class OrderDetailDao extends AbstractDao<OrderDetail> {

    public void saveOrderDetails(OrderDetail orderDetail) {
        save(orderDetail);
    }
}
