package com.example.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by 433132 on 6/24/2016.
 */

@Entity(name = "customer_order")
public class Order implements IDomainModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order"/*, cascade = CascadeType.ALL*/)
    //@Column(name = "order_product_id")
    private List<OrderProduct> orderProduct;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    public Order(Customer customer, List<OrderProduct> orderProduct, OrderDetail orderDetail) {
        this.customer = customer;
        this.orderProduct = orderProduct;
        this.orderDetail = orderDetail;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
