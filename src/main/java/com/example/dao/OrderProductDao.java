package com.example.dao;

import com.example.model.OrderProduct;

/**
 * Created by hadoop on 27/6/16.
 */
public class OrderProductDao extends AbstractDao<OrderProduct> {

    public  void saveOrderProduct(OrderProduct orderProduct) {
        save(orderProduct);
    }

}
