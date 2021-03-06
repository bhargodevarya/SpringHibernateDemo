package com.example.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by 433132 on 6/24/2016.
 */
@Entity(name = "product")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "product")
@NamedQueries({
        @NamedQuery(name = "ProductfindAll", query = "from product p"),
        @NamedQuery(name = "Productfindbrand", query = "from product p where p.brand like :brand")})
public class Product implements IDomainModel,Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    private String description;
    private int price;
    private String name;
    private String brand;

    @ManyToMany
    private Set<Supplier> suppliers;

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Product(String description, int price, String name, String brand) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", suppliers=" + suppliers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProduct_id() == product.getProduct_id() &&
                Objects.equals(getBrand(), product.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id(), getBrand());
    }
}
