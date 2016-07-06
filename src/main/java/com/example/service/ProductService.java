package com.example.service;

import com.example.model.Product;
import org.hibernate.Query;
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

    /**
     * An example of named query with parameter
     * @param brand
     * @return
     */
    @Transactional
    public List<Product> getProductsForBrand(String brand) {
        Query query = getSession(Product.class).getNamedQuery("Productfindbrand");
        query.setParameter("brand","%"+brand+"%");
        return query.list();
    }
}
