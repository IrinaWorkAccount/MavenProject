package org.example.resources;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class OrderItemPK implements Serializable {

    private Long orderId;
    private Long orderItemId;

    public OrderItemPK(Long orderId, Long orderItemId) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
    }

    public OrderItemPK() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK pk = (OrderItemPK) o;
        return Objects.equals(orderId, pk.orderId) &&
                Objects.equals(orderItemId, pk.orderItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderItemId );
    }
}
