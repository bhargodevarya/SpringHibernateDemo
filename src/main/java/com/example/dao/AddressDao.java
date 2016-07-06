package com.example.dao;

import com.example.model.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 433132 on 6/21/2016.
 */
@Repository
@Transactional
public class AddressDao extends AbstractDao<Address> {

    public void saveCountry(Address address) {
        save(address);
    }
}
