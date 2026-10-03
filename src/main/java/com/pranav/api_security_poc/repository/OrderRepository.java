package com.pranav.api_security_poc.repository;

import com.pranav.api_security_poc.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private final Map<Long, Order> orders = new ConcurrentHashMap<>();

    public OrderRepository() {
        orders.put(101L, new Order(101L, "Laptop", "alice"));
        orders.put(102L, new Order(102L, "Phone", "bob"));
    }

    public Order findById(Long id) {
        return orders.get(id);
    }
}