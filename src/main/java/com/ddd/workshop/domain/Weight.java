package com.ddd.workshop.domain;

import java.math.BigDecimal;

public final class Weight {

    private final BigDecimal value;
    private final String unit;

    public Weight(BigDecimal value) {
        this.value = value;
        this.unit = "gm";
    }

    public BigDecimal getValue() {
        return value;
    }
}
