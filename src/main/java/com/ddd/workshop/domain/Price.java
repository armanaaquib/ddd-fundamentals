package com.ddd.workshop.domain;

import java.math.BigDecimal;
import java.util.Currency;

public final class Price {

    private final BigDecimal amount;
    private final Currency currency;

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public Price reduceBy(BigDecimal percentage) {
        final BigDecimal reduceAmount = this.amount.multiply(percentage).divide(new BigDecimal(100));
        BigDecimal reducedAmount = this.amount.subtract(reduceAmount);
        return new Price(reducedAmount, this.currency);
    }
}
