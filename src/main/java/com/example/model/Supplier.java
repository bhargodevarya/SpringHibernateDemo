package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hadoop on 2/7/16.
 */
@Entity(name = "supplier")
public class Supplier implements IDomainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int id;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Since the mappedby property is set, we dont need to set the supplierLocation in the supplier instance.
     * only, supplierLocation.setSupplier() needs to be invoked.
     * supplier_id is maintained at the supplier_location table, supplier table doesnot maintain a FK for supplier_location
     */
    @OneToMany(mappedBy = "supplier")
    private Set<SupplierLocation> supplierLocation;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public Supplier(int id, String name, String email, Set<SupplierLocation> supplierLocation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.supplierLocation = supplierLocation;
    }

    public Supplier() {
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<SupplierLocation> getSupplierLocation() {
        return supplierLocation;
    }

    public void setSupplierLocation(Set<SupplierLocation> supplierLocation) {
        this.supplierLocation = supplierLocation;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", supplierLocation=" + supplierLocation +
                '}';
    }
}
