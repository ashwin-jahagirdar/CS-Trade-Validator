package com.cs.trade.validator;

import java.time.LocalDate;
import java.util.Currency;

public class Utils {

    public static boolean validateDateOrder(LocalDate date1, LocalDate date2) {
        return date1.isBefore(date2);
    }

    public static boolean validateCurrencyCode(String currency) {
        try {
            Currency.getInstance(currency);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
}
