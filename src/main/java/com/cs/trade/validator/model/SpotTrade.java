package com.cs.trade.validator.model;

import com.cs.trade.validator.enums.TradeType;

import java.time.LocalDate;

public class SpotTrade extends Trade {

    private LocalDate valueDate;

    public SpotTrade(TradeType type) {
        super(type);
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }
}
