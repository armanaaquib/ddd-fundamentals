package com.ddd.workshop.domain;

import java.util.UUID;

public class Product {

    private final String name;
    private final Price price;
    private final UUID id;

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return this.name;
    }

    public Price getPrice() {
        return this.price;
    }
}
