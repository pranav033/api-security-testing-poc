package com.pranav.api_security_poc.controller;

import com.pranav.api_security_poc.model.Order;
import com.pranav.api_security_poc.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(
            @PathVariable Long id,
            Authentication authentication) {

        try {

            String username = authentication.getName();

            Order order = orderService.getOrder(id, username);

            if (order == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Order not found");
            }

            return ResponseEntity.ok(order);

        } catch (AccessDeniedException e) {

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("You are not allowed to access this order");
        }
    }
}