package com.example.dao;

import com.example.model.Product;

/**
 * Created by hadoop on 27/6/16.
 */
public class ProductDao extends AbstractDao<Product> {

    public void saveProduct(Product product) {
        save(product);
    }
}
