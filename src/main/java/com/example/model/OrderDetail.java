package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hadoop on 27/6/16.
 */
@Entity(name = "order_details")
public class OrderDetail implements IDomainModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int order_detail_id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_cost")
    private int cost;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    /*//@OneToMany(mappedBy = "order_detail_id")
    @Column(name = "order_product_id")
    private Set<OrderProductDao> orderProduct;*/

    //mappedBy means that the order table will maintain the FK
    @OneToOne(mappedBy = "orderDetail")
    //@JoinColumn(name = "order_id")
    private Order order;

    public OrderDetail(Date orderDate, int cost, Address address, /*Set<OrderProductDao> orderProduct,*/ Order order) {
        this.orderDate = orderDate;
        this.cost = cost;
        this.address = address;
        /*this.orderProduct = orderProduct;*/
        this.order = order;
    }

    public OrderDetail() {
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /*public Set<OrderProductDao> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProductDao> orderProduct) {
        this.orderProduct = orderProduct;
    }*/

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
