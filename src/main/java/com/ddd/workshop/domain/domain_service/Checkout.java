package com.ddd.workshop.domain.domain_service;

import com.ddd.workshop.domain.Cart;
import com.ddd.workshop.domain.Order;
import com.ddd.workshop.domain.Product;
import com.ddd.workshop.domain.Weight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public static final Weight FIFTY_GRAM = new Weight(new BigDecimal(50));

    public Order proceed(Cart cart) {
        if(cart.isCheckedOut()) {
            return null;
        }

        List<Product> products = new ArrayList<>();

        cart.getItems().forEach((item) -> {

            for (int count = 0; count < item.getQuantity(); count++) {
                Product product = count > 0 ?
                        new Product(item.getProduct().getName(), item.getProduct().getPrice(), FIFTY_GRAM) :
                        item.getProduct();
                products.add(product);
            }

        });

        cart.checkout();
        return new Order(products);
    }

}
