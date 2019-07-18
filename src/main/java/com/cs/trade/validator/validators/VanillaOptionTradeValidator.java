package com.cs.trade.validator.validators;

import com.cs.trade.validator.Utils;
import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.model.ValidationError;
import com.cs.trade.validator.model.VanillaOptionTrade;

import java.util.ArrayList;
import java.util.List;

public class VanillaOptionTradeValidator extends TradeValidator {

    private List<String> validStyles;

    public VanillaOptionTradeValidator(Trade trade) {
        super(trade);

        validStyles = new ArrayList<>();
        validStyles.add("EUROPEAN");
        validStyles.add("AMERICAN");
    }

    public VanillaOptionTrade getTradeAsVanillaOptionTrade() {
        return (VanillaOptionTrade) super.getTrade();
    }

    @Override
    public List<ValidationError> validateTrade() {
        super.validateTrade();
        validateDeliveryDateAndTradeDateOrder();
        validatePayCurrencyCode();
        validatePremiumCurrencyCode();
        validateStyle();
        validateExcerciseStartDate();
        validateExpiryDateAndDeliveryDateOrder();
        validatePremiumDateAndDeliveryDateOrder();
        return getValidationErrors();
    }

    //Delivery date considered as Value date for trade type of Option
    private void validateDeliveryDateAndTradeDateOrder() {
        if (!Utils.validateDateOrder(getTradeAsVanillaOptionTrade().getTradeDate(), getTradeAsVanillaOptionTrade().getDeliveryDate())) {
            getValidationErrors().add(ValidationError.INVALID_DELIVERY_DATE_AND_TRADE_DATE_ORDER);
        }
    }

    private void validatePayCurrencyCode() {
        if (!Utils.validateCurrencyCode(getTradeAsVanillaOptionTrade().getPayCcy())) {
            getValidationErrors().add(ValidationError.INVALID_CURRENCY_CODE_PAYCCY);
        }
    }

    private void validatePremiumCurrencyCode() {
        if (!Utils.validateCurrencyCode(getTradeAsVanillaOptionTrade().getPremiumCcy())) {
            getValidationErrors().add(ValidationError.INVALID_CURRENCY_CODE_PREMIUMCCY);
        }
    }

    private void validateStyle() {
        if (!validStyles.contains(getTradeAsVanillaOptionTrade().getStyle())) {
            getValidationErrors().add(ValidationError.INVALID_STYLE);
        }
    }

    private void validateExcerciseStartDate() {
        if (getTradeAsVanillaOptionTrade().getStyle().equalsIgnoreCase("AMERICAN")) {
            boolean comapreWithTradeDate = Utils.validateDateOrder(getTradeAsVanillaOptionTrade().getTradeDate(), getTradeAsVanillaOptionTrade().getExcerciseStartDate());
            boolean comapreWithExpiryDate = Utils.validateDateOrder(getTradeAsVanillaOptionTrade().getExcerciseStartDate(), getTradeAsVanillaOptionTrade().getExpiryDate());
            if ((!comapreWithExpiryDate) || (!comapreWithTradeDate)) {
                getValidationErrors().add(ValidationError.INVALID_EXERCISE_START_DATE);
            }
        }
    }

    private void validateExpiryDateAndDeliveryDateOrder() {
        if (!Utils.validateDateOrder(getTradeAsVanillaOptionTrade().getExpiryDate(), getTradeAsVanillaOptionTrade().getDeliveryDate())) {
            getValidationErrors().add(ValidationError.INVALID_EXPIRY_DATE_AND_DELIVERY_DATE_ORDER);
        }
    }

    private void validatePremiumDateAndDeliveryDateOrder() {
        if (!Utils.validateDateOrder(getTradeAsVanillaOptionTrade().getPremiumDate(), getTradeAsVanillaOptionTrade().getDeliveryDate())) {
            getValidationErrors().add(ValidationError.INVALID_PREMIUM_DATE_AND_DELIVERY_DATE_ORDER);
        }
    }
}
