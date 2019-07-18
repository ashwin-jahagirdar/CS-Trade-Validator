package com.cs.trade.validator.model;

import com.cs.trade.validator.enums.TradeType;

import java.time.LocalDate;

public class ForwardTrade extends Trade {

    private LocalDate valueDate;

    public ForwardTrade(TradeType type) {
        super(type);
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }
}
