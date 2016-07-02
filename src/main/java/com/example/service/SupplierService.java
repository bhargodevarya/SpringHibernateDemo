package com.example.service;

import com.example.model.Supplier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hadoop on 2/7/16.
 */
@Component
public class SupplierService extends BaseService<Supplier> {

    @Transactional
    public void createSupplier(Supplier supplier) {
        create(supplier);
    }

}
