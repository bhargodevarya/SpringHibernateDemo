package com.example.dao;

import com.example.model.Supplier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 2/7/16.
 */
@Transactional
@Repository
public class SupplierDao extends AbstractDao<Supplier> {

    //@Transactional
    public void saveSupplier(Supplier supplier) {
        save(supplier);
    }
}
