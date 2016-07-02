package com.example.service;

import com.example.model.SupplierLocation;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 2/7/16.
 */
@Component
public class SupplierLocationService extends BaseService<SupplierLocation> {

    @Transactional
    public void createSupplierLocation(SupplierLocation supplierLocation) {
        create(supplierLocation);
    }

}
