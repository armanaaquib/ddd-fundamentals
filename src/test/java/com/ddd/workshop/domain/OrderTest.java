package com.ddd.workshop.domain;

import com.ddd.workshop.domain.domain_service.Checkout;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    public static final Price HUNDRED_RUPEES = new Price(new BigDecimal(100), Currency.getInstance("INR"));
    public static final Price FIFTY_RUPEES = new Price(new BigDecimal(50), Currency.getInstance("INR"));
    public static final Weight FIFTY_GRAM = new Weight(new BigDecimal(50));
    public static final Product I_PAD_PRO = new Product("IPad Pro", HUNDRED_RUPEES, FIFTY_GRAM);
    public static final Product HERO_INK_PEN = new Product("Hero ink Pen", FIFTY_RUPEES, FIFTY_GRAM);


    @Test
    public void shouldCalculatePriceOfOrder() {
        final Item item1 = new Item(I_PAD_PRO, 1);
        final Item item2 = new Item(HERO_INK_PEN, 2);
        final Cart cart = new Cart();
        cart.add(item1);
        cart.add(item2);

        final Checkout checkout = new Checkout();
        final Order order = checkout.proceed(cart);
        final Price orderCost = order.calculateCost();

        assertEquals(new BigDecimal("201.5"), orderCost.getAmount());

    }
}
