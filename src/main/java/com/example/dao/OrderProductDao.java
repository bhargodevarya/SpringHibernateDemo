package com.example.dao;

import com.example.model.OrderProduct;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TableGenerator;

/**
 * Created by hadoop on 27/6/16.
 */
public class OrderProductDao extends AbstractDao<OrderProduct> {

    @Transactional
    public  void saveOrderProduct(OrderProduct orderProduct) {
        save(orderProduct);
    }

}
