package com.ddd.workshop.domain.domain_service;

import com.ddd.workshop.domain.Cart;
import com.ddd.workshop.domain.Order;
import com.ddd.workshop.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public Order proceed(Cart cart) {
        if(cart.isCheckedOut()) {
            return null;
        }

        List<Product> products = new ArrayList<>();

        cart.getItems().forEach((item) -> {

            for (int count = 0; count < item.getQuantity(); count++) {
                Product product = count > 0 ?
                        new Product(item.getProduct().getName(), item.getProduct().getPrice()) :
                        item.getProduct();
                products.add(product);
            }

        });

        cart.checkout();
        return new Order(products);
    }

}
