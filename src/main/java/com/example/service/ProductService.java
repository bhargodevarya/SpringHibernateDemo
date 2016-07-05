package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hadoop on 2/7/16.
 */
@Component
public class ProductService extends BaseService<Product> {

    @Transactional
    public void saveProduct(Product product) {
        create(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return getSession(Product.class).getNamedQuery("ProductfindAll").list();
    }
}
