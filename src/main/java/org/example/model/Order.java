package org.example.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private long orderId;

    @OneToMany//(mappedBy = "order", cascade = CascadeType.ALL)
    //@JoinColumn(name="order_id")
    private List<OrderItem> orderItem;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    private int overallPrice;
    private String currency;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @CreationTimestamp
    private LocalDateTime updateDateTime;

    public Order(int overallPrice, String currency) {
        this.overallPrice = overallPrice;
        this.currency = currency;
    }

    public Order() {
        // Auto-generated constructor stub
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public int getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(int overallPrice) {
        this.overallPrice = overallPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


}
