package com.example.dao;

import com.example.model.Customer;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 433132 on 6/8/2016.
 */
public class CustomerDao extends AbstractDao<Customer> {

    //@Transactional
    public void saveCustomer(Customer customer) {
        save(customer);
    }
}
