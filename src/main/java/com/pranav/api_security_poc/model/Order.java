package com.pranav.api_security_poc.model;

public class Order {

    private Long id;
    private String product;
    private String username;

    public Order(Long id, String product, String username) {
        this.id = id;
        this.product = product;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getUsername() {
        return username;
    }
}