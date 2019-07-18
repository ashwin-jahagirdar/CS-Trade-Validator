package com.cs.trade.validator.validators;

import com.cs.trade.validator.Utils;
import com.cs.trade.validator.model.SpotTrade;
import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.model.ValidationError;

import java.util.List;

public class SpotTradeValidator extends TradeValidator {

    public SpotTradeValidator(Trade trade) {
        super(trade);
    }

    public SpotTrade getTradeAsSpotTrade() {
        return (SpotTrade) super.getTrade();
    }

    @Override
    public List<ValidationError> validateTrade() {
        super.validateTrade();
        validateValueDateAndTradeDateOrder();
        return getValidationErrors();
    }

    private void validateValueDateAndTradeDateOrder() {
        if (!Utils.validateDateOrder(getTradeAsSpotTrade().getTradeDate(), getTradeAsSpotTrade().getValueDate())) {
            getValidationErrors().add(ValidationError.INVALID_VALUE_DATE_AND_TRADE_DATE_ORDER);
        }
    }
}
