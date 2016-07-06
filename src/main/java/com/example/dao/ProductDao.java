package com.example.dao;

import com.example.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 27/6/16.
 */
@Repository
@Transactional
public class ProductDao extends AbstractDao<Product> {

    //@Transactional
    public void saveProduct(Product product) {
        save(product);
    }
}
