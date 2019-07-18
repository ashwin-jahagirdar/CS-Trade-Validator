package com.cs.trade.validator.model;

import com.cs.trade.validator.enums.TradeType;
import java.time.LocalDate;

public class Trade {

    private String customer;
    private String ccyPair;
    private TradeType type;
    private String direction;
    private LocalDate tradeDate;
    private String amount1;
    private String amount2;
    private String rate;
    private String legalEntity;
    private String trader;

    public Trade(TradeType type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public TradeType getType() {
        return type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getAmount1() {
        return amount1;
    }

    public void setAmount1(String amount1) {
        this.amount1 = amount1;
    }

    public String getAmount2() {
        return amount2;
    }

    public void setAmount2(String amount2) {
        this.amount2 = amount2;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }
}
