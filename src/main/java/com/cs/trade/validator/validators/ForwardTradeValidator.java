package com.cs.trade.validator.validators;

import com.cs.trade.validator.Utils;
import com.cs.trade.validator.model.ForwardTrade;
import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.model.ValidationError;
import java.util.List;

public class ForwardTradeValidator extends TradeValidator {

    public ForwardTradeValidator(Trade trade) {
        super(trade);
    }

    public ForwardTrade getTradeAsForwardTrade() {
        return (ForwardTrade) super.getTrade();
    }

    @Override
    public List<ValidationError> validateTrade() {
        super.validateTrade();
        validateValueDateAndTradeDateOrder();
        return getValidationErrors();
    }

    private void validateValueDateAndTradeDateOrder() {
        if (!Utils.validateDateOrder(getTradeAsForwardTrade().getTradeDate(), getTradeAsForwardTrade().getValueDate())) {
            getValidationErrors().add(ValidationError.INVALID_VALUE_DATE_AND_TRADE_DATE_ORDER);
        }
    }

}
