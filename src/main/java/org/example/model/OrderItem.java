package org.example.model;

import jakarta.persistence.*;
import org.example.resources.OrderItemPK;

import java.io.Serializable;

@Entity
@Table(name = "order_items")
//@IdClass(OrderItemPK.class)
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id;
/*
    @Id
    private Long orderItemId;*/

   //@Id
@MapsId("orderId")
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    //@Id
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;


    private int quantity;
    private double pricePerUnit;
    private double totalPrice;

    public OrderItem(Order order, Product product, int quantity, double pricePerUnit, double totalPrice) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;
    }

    public OrderItem() {
        // Auto-generated constructor stub
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    /*    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }*/

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
