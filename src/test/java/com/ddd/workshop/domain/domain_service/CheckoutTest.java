package com.ddd.workshop.domain.domain_service;

import com.ddd.workshop.domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest {

    public static final Price TEN_RUPEES = new Price(new BigDecimal(10), Currency.getInstance("INR"));
    public static final Product I_PAD_PRO = new Product("IPad Pro", TEN_RUPEES);
    public static final Product HERO_INK_PEN = new Product("Hero ink Pen", TEN_RUPEES);


    @Test
    public void shouldCreateAnOrder() {
        final Item item1 = new Item(I_PAD_PRO, 1);
        final Item item2 = new Item(HERO_INK_PEN, 2);
        final Cart cart = new Cart();
        cart.add(item1);
        cart.add(item2);

        final Checkout checkout = new Checkout();
        final Order order = checkout.proceed(cart);

        assertTrue(cart.isCheckedOut());
        assertEquals(3, order.getProducts().size());
    }
}
