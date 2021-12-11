package com.ddd.workshop.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final String name;
    private final Price price;
    private final Weight weight;
    private final UUID id;

    public Product(String name, Price price, Weight weight) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public Price getPrice() {
        return this.price;
    }

    public Price getWeighBasedPrice() {
        final BigDecimal weightPrice = this.weight.getValue().multiply(new BigDecimal(0.01));
        return new Price(this.price.getAmount().add(weightPrice), this.price.getCurrency());
    }
}
