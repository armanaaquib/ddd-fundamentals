package com.ddd.workshop.domain.domain_service;

import com.ddd.workshop.domain.Price;

import java.math.BigDecimal;
import java.util.HashMap;

public class CompetitorBasedPricer {

    public Price getDiscountedPrice(String productName, HashMap<String, Price> competitorPrices) {
        Price competitorPrice = competitorPrices.get(productName);

        if (competitorPrice == null) {
            return null;
        }

        final BigDecimal discountPercentage = new BigDecimal(10);
        return competitorPrice.reduceBy(discountPercentage);
    }

}
