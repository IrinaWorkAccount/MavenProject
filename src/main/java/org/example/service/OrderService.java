package org.example.service;

import org.example.dao.OrderRepository;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order create(Order order, List<OrderItem>orderItems){
        if (orderRepository != null) {
            Order savedOrder = orderRepository.save(order);
        for (OrderItem item : orderItems) {
         item.setOrder(savedOrder);
        }
        return savedOrder;
        } else {
            throw new RuntimeException("OrderRepository is null");
        }
    }

    }

