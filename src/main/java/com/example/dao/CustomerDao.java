package com.example.dao;

import com.example.model.Customer;

/**
 * Created by 433132 on 6/8/2016.
 */
public class CustomerDao extends AbstractDao {

    public void saveCustomer(Customer customer) {
        getHibernateTemplate().save(customer);
    }
}
