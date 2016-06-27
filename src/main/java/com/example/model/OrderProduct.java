package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hadoop on 27/6/16.
 */
@Entity(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private int id;

    /*@ManyToOne
    //@Column(name = "order_detail_id")
    private OrderDetail orderDetail;*/

    @ManyToOne
    //@Column(name = "order_id")
    private Order order;

    @OneToMany
    //@Column(name = "product_id")
    private List<Product> product;

    public OrderProduct(/*OrderDetail orderDetail, Order order,*/ List<Product> product) {
       // this.orderDetail = orderDetail;
        //this.order = order;
        this.product = product;
    }

    public OrderProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }*/

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
