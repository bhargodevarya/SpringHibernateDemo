package com.example.dao;

import com.example.model.Product;
import com.example.model.Supplier;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Product> getProductsFor() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Product.class);
        Disjunction disjunction = Restrictions.or(Restrictions.gt("price",12000)
                ,Restrictions.like("brand","A%")
                ,Restrictions.not(Restrictions.like("name","%r%")));
        criteria.add(disjunction);
        List<Product> productList = criteria.list();
        productList.forEach(n -> Hibernate.initialize(n.getSuppliers()));
        return productList;
    }
}
