package com.example.dao;

import com.example.model.Address;

/**
 * Created by 433132 on 6/21/2016.
 */
public class AddressDao extends AbstractDao<Address> {

    public void saveCountry(Address address) {
        save(address);
    }
}
