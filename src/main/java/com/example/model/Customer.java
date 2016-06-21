package com.example.model;

import javax.persistence.*;

/**
 * Created by 433132 on 6/8/2016.
 */

@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratorType()
    private int id;

    private String fistName;
    private String lastName;
    private String email;

    //@OneToOne
    //@JoinColumn(name = "ADDRESS_ID")
    //@PrimaryKeyJoinColumn
    //private Address address;

    public Customer(String fistName, String lastName, String email/*, Address address*/) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        /*this.address = address;*/
    }

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
