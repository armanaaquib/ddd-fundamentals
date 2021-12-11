package com.ddd.workshop.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private final List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public Price calculateCost() {
        BigDecimal cost = new BigDecimal(0);

        for (Product product : this.products) {
            cost = cost.add(product.getWeighBasedPrice().getAmount());
        }

        return new Price(cost, this.products.get(0).getPrice().getCurrency());
    }
}
