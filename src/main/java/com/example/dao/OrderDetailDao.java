package com.example.dao;

import com.example.model.OrderDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 27/6/16.
 */
@Repository
@Transactional
public class OrderDetailDao extends AbstractDao<OrderDetail> {

    public void saveOrderDetails(OrderDetail orderDetail) {
        save(orderDetail);
    }
}
