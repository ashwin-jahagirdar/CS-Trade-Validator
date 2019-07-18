package com.cs.trade.validator.model;

public enum ValidationError {

    INVALID_COUNTER_PARTY ("Customer", "Invalid customer"),
    INVALID_CURRENCY_CODE_PAIR ("Currency Pair", "Currency code is not a valid ISO 4217 code"),
    INVALID_CURRENCY_CODE_PAYCCY ("PayCcy", "Currency code is not a valid ISO 4217 code"),
    INVALID_CURRENCY_CODE_PREMIUMCCY ("PremiumCcy", "Currency code is not a valid ISO 4217 code"),
    INVALID_VALUE_DATE_AND_TRADE_DATE_ORDER ("Value date and Trade Date", "The Value date and Trade Date order is invalid"),
    INVALID_DELIVERY_DATE_AND_TRADE_DATE_ORDER ("Delivery date and Trade Date", "The Delivery date and Trade Date order is invalid"),
    INVALID_STYLE ("Style", "The style is invalid"),
    INVALID_EXERCISE_START_DATE ("ExerciseStartDate", "The ExerciseStartDate is invalid"),
    INVALID_EXPIRY_DATE_AND_DELIVERY_DATE_ORDER ("Expiry date and Delivery Date", "The Expiry date and Delivery Date order is invalid"),
    INVALID_PREMIUM_DATE_AND_DELIVERY_DATE_ORDER ("Premium date and Delivery Date", "The Premium date and Delivery Date order is invalid"),
    ;

    private String fields;
    private String errorMessage;

    ValidationError(String fields, String errorMessage) {
        this.fields = fields;
        this.errorMessage = errorMessage;
    }

    public String getFields() {
        return fields;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
