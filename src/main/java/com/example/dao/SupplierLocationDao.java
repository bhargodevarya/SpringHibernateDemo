package com.example.dao;

import com.example.model.SupplierLocation;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 2/7/16.
 */
@Component
public class SupplierLocationDao extends AbstractDao<SupplierLocation> {

    @Transactional
    public void saveSupplierLocation(SupplierLocation supplierLocation) {
        save(supplierLocation);
    }

}
