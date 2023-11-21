package org.example.dao;

import org.example.model.OrderItem;
import org.example.resources.OrderItemPK;
import org.springframework.data.repository.CrudRepository;

public interface  OrderItemRepository extends CrudRepository<OrderItem, OrderItemPK> {
}
