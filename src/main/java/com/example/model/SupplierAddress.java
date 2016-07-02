package com.example.model;

import javax.persistence.*;

/**
 * Created by hadoop on 2/7/16.
 */
@Embeddable
public class SupplierAddress {

    private String addrLine1;
    private String addrLine2;
    private String city;
    private int zipCode;
    private String state;

    public SupplierAddress() {
    }

    public SupplierAddress(String addrLine1, String addrLine2, String city, int zipCode, String state) {
        this.addrLine1 = addrLine1;
        this.addrLine2 = addrLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
