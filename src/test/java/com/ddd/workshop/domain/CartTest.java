package com.ddd.workshop.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    public static final Price TEN_RUPEES = new Price(new BigDecimal(10), Currency.getInstance("INR"));
    public static final Weight FIFTY_GRAM = new Weight(new BigDecimal(50));
    public static final Product I_PAD_PRO = new Product("IPad Pro", TEN_RUPEES, FIFTY_GRAM);
    public static final Product HERO_INK_PEN = new Product("Hero ink Pen", TEN_RUPEES, FIFTY_GRAM);

    @ParameterizedTest
    @ValueSource(strings = {"IPad Pro", "Hero ink Pen"})
    public void shouldAddAProductToCart(String name) {
        final Product product = new Product(name, TEN_RUPEES, FIFTY_GRAM);
        final Item item = new Item(product, 1);
        final Cart cart = new Cart();

        cart.add(item);

        assertEquals(product.getName(), cart.getItems().get(0).getProduct().getName());
    }

    @Test
    public void shouldAddItemWithQuantityToCart() {
        final Item item = new Item(I_PAD_PRO, 2);
        final Cart cart = new Cart();

        cart.add(item);

        final Item actualItem = cart.getItems().get(0);
        assertEquals(item.getProduct().getName(), actualItem.getProduct().getName());
        assertEquals(item.getQuantity(), actualItem.getQuantity());
    }

    @Test
    public void shouldRemoveAnItem() {
        final Item item1 = new Item(I_PAD_PRO, 1);
        final Item item2 = new Item(HERO_INK_PEN, 1);
        final Cart cart = new Cart();
        cart.add(item1);
        cart.add(item2);

        cart.remove(item1);

        assertEquals(1, cart.getItems().size());
    }

    @Test
    public void shouldGiveRemovedItemNames() {
        final Item item1 = new Item(I_PAD_PRO, 1);
        final Item item2 = new Item(HERO_INK_PEN, 1);
        final Cart cart = new Cart();
        cart.add(item1);
        cart.add(item2);
        cart.remove(item1);

        final Set<String> actualRemovedItems = cart.getRemovedItems();

        assertTrue(actualRemovedItems.contains(I_PAD_PRO.getName()));
    }

    @Test
    public void shouldNotAddToRemovedItemsIfItemIsNotPresentInTheCart() {
        final Item item2 = new Item(HERO_INK_PEN, 1);
        final Cart cart = new Cart();
        cart.add(item2);
        final Item item1 = new Item(I_PAD_PRO, 1);
        cart.remove(item1);

        final Set<String> actualRemovedItems = cart.getRemovedItems();

        assertFalse(actualRemovedItems.contains(I_PAD_PRO.getName()));
    }

    @Test
    public void shouldDifferentiateCarts() {
        final Cart cart1 = new Cart();
        final Item item1 = new Item(I_PAD_PRO, 1);
        cart1.add(item1);
        final Item item2 = new Item(HERO_INK_PEN, 1);
        final Cart cart2 = new Cart();
        cart2.add(item2);

        assertNotEquals(cart1, cart2);
        assertEquals(cart1, cart1);
    }

    @Test
    public void shouldAddProductWithPriceToCart() {
        final Item item = new Item(I_PAD_PRO, 1);
        final Cart cart = new Cart();

        cart.add(item);

        final Product actualProduct = cart.getItems().get(0).getProduct();
        assertEquals(I_PAD_PRO.getName(), actualProduct.getName());
        assertEquals(I_PAD_PRO.getPrice().getAmount(), actualProduct.getPrice().getAmount());
        assertEquals(I_PAD_PRO.getPrice().getCurrency(), actualProduct.getPrice().getCurrency());
    }

}
