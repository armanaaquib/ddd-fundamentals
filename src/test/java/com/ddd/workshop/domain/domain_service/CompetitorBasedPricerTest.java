package com.ddd.workshop.domain.domain_service;

import com.ddd.workshop.domain.Price;
import com.ddd.workshop.domain.Product;
import com.ddd.workshop.domain.Weight;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompetitorBasedPricerTest {

    public static final Price HUNDRED_RUPEES = new Price(new BigDecimal(100), Currency.getInstance("INR"));
    public static final Price FIFTY_RUPEES = new Price(new BigDecimal(50), Currency.getInstance("INR"));
    public static final Weight FIFTY_GRAM = new Weight(new BigDecimal(50));
    public static final Product I_PAD_PRO = new Product("IPad Pro", HUNDRED_RUPEES, FIFTY_GRAM);
    public static final Product HERO_INK_PEN = new Product("Hero ink Pen", FIFTY_RUPEES, FIFTY_GRAM);

    @Test
    public void shouldGiveDiscount() {
        final HashMap<String, Price> competitorPrices = new HashMap<>();
        competitorPrices.put(I_PAD_PRO.getName(), I_PAD_PRO.getPrice());
        competitorPrices.put(HERO_INK_PEN.getName(), HERO_INK_PEN.getPrice());

        final CompetitorBasedPricer priceCalculator = new CompetitorBasedPricer();
        final Price price = priceCalculator.getDiscountedPrice(I_PAD_PRO.getName(), competitorPrices);

        assertEquals(new BigDecimal(90), price.getAmount());
    }

}
