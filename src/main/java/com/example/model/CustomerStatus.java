package com.example.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by 433132 on 6/24/2016.
 */
public enum CustomerStatus {
    ACTIVE("active"),INACTIVE("inactive");

    private String status;

    CustomerStatus(String status) {
        this.status = status;
    }

    public Optional<CustomerStatus> getCustomerStatus(String customerStatus) {
        return Arrays.asList(CustomerStatus.values()).
                stream().filter(n -> n.toString().
                equals(customerStatus)).findFirst();
    }


    @Override
    public String toString() {
        return status;
    }
}
