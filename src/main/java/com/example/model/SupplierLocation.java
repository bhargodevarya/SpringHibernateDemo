package com.example.model;

import javax.persistence.*;

/**
 * Created by hadoop on 2/7/16.
 */
@Entity(name = "supplier_location")
public class SupplierLocation implements IDomainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_location_id")
    private int id;

    @Embedded
    private SupplierAddress supplierAddress;

    /**
     * SInce cascade type is set, we dont need to save the supplier explicitly.
     * When the supplierlocation instance gets saved, supplier also gets saved
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public SupplierLocation(int id, SupplierAddress supplierAddress, Supplier supplier) {
        this.id = id;
        this.supplierAddress = supplierAddress;
        this.supplier = supplier;
    }

    public SupplierLocation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupplierAddress getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(SupplierAddress supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "SupplierLocation{" +
                "supplierAddress=" + supplierAddress +
                ", id=" + id +
                '}';
    }
}
