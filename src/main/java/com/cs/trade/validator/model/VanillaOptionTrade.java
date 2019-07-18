package com.cs.trade.validator.model;

import com.cs.trade.validator.enums.TradeType;
import java.time.LocalDate;

public class VanillaOptionTrade extends Trade {

    private String style;
    private String strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private String payCcy;
    private String premium;
    private String premiumCcy;
    private String premiumType;
    private LocalDate premiumDate;
    private LocalDate excerciseStartDate;

    public VanillaOptionTrade(TradeType type) {
        super(type);
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public void setPayCcy(String payCcy) {
        this.payCcy = payCcy;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getPremiumCcy() {
        return premiumCcy;
    }

    public void setPremiumCcy(String premiumCcy) {
        this.premiumCcy = premiumCcy;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(String premiumType) {
        this.premiumType = premiumType;
    }

    public LocalDate getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(LocalDate premiumDate) {
        this.premiumDate = premiumDate;
    }

    public LocalDate getExcerciseStartDate() {
        return excerciseStartDate;
    }

    public void setExcerciseStartDate(LocalDate excerciseStartDate) {
        this.excerciseStartDate = excerciseStartDate;
    }
}
