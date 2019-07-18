package com.cs.trade.validator.model;

public class RawTradeInput {

    private String customer;
    private String ccyPair;
    private String type;
    private String direction;
    private String tradeDate;
    private String amount1;
    private String amount2;
    private String rate;
    private String legalEntity;
    private String trader;
    private String valueDate;

    private String style;
    private String strategy;
    private String deliveryDate;
    private String expiryDate;
    private String payCcy;
    private String premium;
    private String premiumCcy;
    private String premiumType;
    private String premiumDate;
    private String excerciseStartDate;

    public String getCustomer() {
        return customer;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public String getType() {
        return type;
    }

    public String getDirection() {
        return direction;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String getAmount1() {
        return amount1;
    }

    public String getAmount2() {
        return amount2;
    }

    public String getRate() {
        return rate;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public String getTrader() {
        return trader;
    }

    public String getValueDate() {
        return valueDate;
    }

    public String getStyle() {
        return style;
    }

    public String getStrategy() {
        return strategy;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public String getPremium() {
        return premium;
    }

    public String getPremiumCcy() {
        return premiumCcy;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public String getPremiumDate() {
        return premiumDate;
    }

    public String getExcerciseStartDate() {
        return excerciseStartDate;
    }

    @Override
    public String toString() {
        return "RawTradeInput{" +
                "customer='" + customer + '\'' +
                ", ccyPair='" + ccyPair + '\'' +
                ", type='" + type + '\'' +
                ", direction='" + direction + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", amount1='" + amount1 + '\'' +
                ", amount2='" + amount2 + '\'' +
                ", rate='" + rate + '\'' +
                ", legalEntity='" + legalEntity + '\'' +
                ", trader='" + trader + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", style='" + style + '\'' +
                ", strategy='" + strategy + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", payCcy='" + payCcy + '\'' +
                ", premium='" + premium + '\'' +
                ", premiumCcy='" + premiumCcy + '\'' +
                ", premiumType='" + premiumType + '\'' +
                ", premiumDate='" + premiumDate + '\'' +
                ", excerciseStartDate='" + excerciseStartDate + '\'' +
                '}';
    }
}
