package org.example.service;

import org.example.dao.OrderItemRepository;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;


    public OrderItem createOrderItem(Order order, Product product, int quantity, double pricePerUnit, double totalPrice){
        if (orderItemRepository != null) {
            product.setQuantityOnStock(product.getQuantityOnStock()-quantity);
            OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPricePerUnit(pricePerUnit);
        orderItem.setTotalPrice(totalPrice);
        orderItemRepository.save(orderItem);
        return orderItem;
    } else {
        throw new RuntimeException("OrderItemRepository is null");
    }
}
    }


