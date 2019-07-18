package com.cs.trade.validator.factory;

import com.cs.trade.validator.enums.TradeType;
import com.cs.trade.validator.model.*;

import java.time.LocalDate;
import java.util.Optional;

public enum TradeFactory {

    INSTANCE;
    private static final String TRADE_TYPE_SPOT = "Spot";
    private static final String TRADE_TYPE_FORWARD = "Forward";
    private static final String TRADE_TYPE_OPTION = "VanillaOption";
    private static final String TRADE_STYLE_AMERICAN = "AMERICAN";

    public Optional<Trade> getTrade(RawTradeInput rawTradeInput) {
        switch (rawTradeInput.getType()) {
            case TRADE_TYPE_SPOT:
                return Optional.of(createSpotTrade(rawTradeInput));
            case TRADE_TYPE_FORWARD:
                return Optional.of(createForwardTrade(rawTradeInput));
            case TRADE_TYPE_OPTION:
                return Optional.of(createVanillaOptionTrade(rawTradeInput));
            default:
                return Optional.empty();
        }
    }

    private SpotTrade createSpotTrade(RawTradeInput rawTradeInput) {
        SpotTrade spotTrade = new SpotTrade(TradeType.SPOT_TRADE);
        setCommonTradeFields(spotTrade, rawTradeInput);
        spotTrade.setValueDate(LocalDate.parse(rawTradeInput.getValueDate()));
        return spotTrade;
    }

    private ForwardTrade createForwardTrade(RawTradeInput rawTradeInput) {
        ForwardTrade forwardTrade = new ForwardTrade(TradeType.FORWARD_TRADE);
        setCommonTradeFields(forwardTrade, rawTradeInput);
        forwardTrade.setValueDate(LocalDate.parse(rawTradeInput.getValueDate()));
        return forwardTrade;
    }

    private VanillaOptionTrade createVanillaOptionTrade(RawTradeInput rawTradeInput) {
        VanillaOptionTrade vanillaOptionTrade = new VanillaOptionTrade(TradeType.VANILLA_OPTION_TRADE);
        setCommonTradeFields(vanillaOptionTrade, rawTradeInput);
        vanillaOptionTrade.setStyle(rawTradeInput.getStyle());
        vanillaOptionTrade.setStrategy(rawTradeInput.getStrategy());
        vanillaOptionTrade.setDeliveryDate(LocalDate.parse(rawTradeInput.getDeliveryDate()));
        vanillaOptionTrade.setExpiryDate(LocalDate.parse(rawTradeInput.getExpiryDate()));
        vanillaOptionTrade.setPayCcy(rawTradeInput.getPayCcy());
        vanillaOptionTrade.setPremium(rawTradeInput.getPremium());
        vanillaOptionTrade.setPremiumCcy(rawTradeInput.getPremiumCcy());
        vanillaOptionTrade.setPremiumType(rawTradeInput.getPremiumType());
        vanillaOptionTrade.setPremiumDate(LocalDate.parse(rawTradeInput.getPremiumDate()));
        if (vanillaOptionTrade.getStyle().equalsIgnoreCase(TRADE_STYLE_AMERICAN)) {
            vanillaOptionTrade.setExcerciseStartDate(LocalDate.parse(rawTradeInput.getExcerciseStartDate()));
        }
        return vanillaOptionTrade;
    }

    private void setCommonTradeFields(Trade trade, RawTradeInput rawTradeInput) {
        trade.setCustomer(rawTradeInput.getCustomer());
        trade.setCcyPair(rawTradeInput.getCcyPair());
        trade.setDirection(rawTradeInput.getDirection());
        trade.setTradeDate(LocalDate.parse(rawTradeInput.getTradeDate()));
        trade.setAmount1(rawTradeInput.getAmount1());
        trade.setAmount2(rawTradeInput.getAmount2());
        trade.setRate(rawTradeInput.getRate());
        trade.setLegalEntity(rawTradeInput.getLegalEntity());
        trade.setTrader(rawTradeInput.getTrader());
    }
}
