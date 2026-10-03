package com.pranav.api_security_poc.service;

import com.pranav.api_security_poc.model.Order;
import com.pranav.api_security_poc.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.access.AccessDeniedException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long id, String username) {

    Order order = orderRepository.findById(id);

    if (order == null) {
        return null;
    }

    if (!order.getUsername().equals(username)) {
        throw new AccessDeniedException("You are not allowed to access this order");
    }

    return order;
}
}