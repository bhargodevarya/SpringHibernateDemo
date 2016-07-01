package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 433132 on 6/8/2016.
 */

@Entity(name = "customer")
public class Customer implements IDomainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;

    private String fistName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    @OneToMany(mappedBy = "customer")
    private Set<Address> address;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Customer(String fistName, String lastName, String email, Set<Address> address) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public Customer() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
