package com.cs.trade.validator.factory;

import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.validators.ForwardTradeValidator;
import com.cs.trade.validator.validators.SpotTradeValidator;
import com.cs.trade.validator.validators.TradeValidator;
import com.cs.trade.validator.validators.VanillaOptionTradeValidator;

public enum TradeValidatorFactory {

    INSTANCE;

    public TradeValidator getTradeValidator(Trade trade) {
        switch (trade.getType()) {
            case FORWARD_TRADE:
                return new ForwardTradeValidator(trade);
            case SPOT_TRADE:
                return new SpotTradeValidator(trade);
            case VANILLA_OPTION_TRADE:
                return new VanillaOptionTradeValidator(trade);
            default:
                return null;
        }
    }
}
