package com.cs.trade.validator.validators;

import com.cs.trade.validator.Utils;
import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.model.ValidationError;

import java.util.ArrayList;
import java.util.List;

public class TradeValidator {

    private Trade trade;
    private List<String> validCounterParties;
    private List<ValidationError> validationErrors;

    public TradeValidator(Trade trade) {
        this.trade = trade;

        //TODO These values should be retrieved from data store
        validCounterParties = new ArrayList<>();
        validCounterParties.add("PLUTO1");
        validCounterParties.add("PLUTO2");

        validationErrors = new ArrayList<>();
    }

    public Trade getTrade() {
        return trade;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public List<ValidationError> validateTrade() {
        validateCounterParty();
        validateCurrencyCode();
        return validationErrors;
    }

    private void validateCounterParty() {
        if (!validCounterParties.contains(trade.getCustomer())) {
            validationErrors.add(ValidationError.INVALID_COUNTER_PARTY);
        }
    }

    private void validateCurrencyCode() {
        String ccyPair = trade.getCcyPair();
        if ((!Utils.validateCurrencyCode(ccyPair.substring(0,3))) || (!Utils.validateCurrencyCode(ccyPair.substring(3)))) {
            validationErrors.add(ValidationError.INVALID_CURRENCY_CODE_PAIR);
        }
    }
}
