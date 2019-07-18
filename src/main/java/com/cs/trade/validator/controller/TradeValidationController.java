package com.cs.trade.validator.controller;

import com.cs.trade.validator.factory.TradeFactory;
import com.cs.trade.validator.factory.TradeValidatorFactory;
import com.cs.trade.validator.model.RawTradeInput;
import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.model.ValidationError;
import com.cs.trade.validator.validators.TradeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

@RestController
public class TradeValidationController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path= "/validate-trades", consumes = "application/json", produces = "application/json")
    public Map<String, List<String>> validateTrades(@RequestBody List<RawTradeInput> rawTrades) {
        List<Optional<Trade>> trades = rawTrades.stream().map(rawTradeInput -> TradeFactory.INSTANCE.getTrade(rawTradeInput)).collect(toList());
        Map<String, List<String>> errorsByTrade = new LinkedHashMap<>();

        for (int i=0; i<trades.size(); ++i) {
            Optional<Trade> trade = trades.get(i);
            if (trade.isPresent()) {
                TradeValidator tradeValidator = TradeValidatorFactory.INSTANCE.getTradeValidator(trade.get());
                //List<ValidationError> validationErrors = tradeValidator.validateTrade();
                List<String> validationResults = tradeValidator.validateTrade()
                        .stream()
                        .map(validationError -> validationError.getFields() + " - " + validationError.getErrorMessage())
                        .collect(toList());
                if (validationResults.isEmpty()) {
                    validationResults.add("Validation successful");
                }
                errorsByTrade.put("Trade No " + (i + 1), validationResults);
            } else {
                LOGGER.warn("Invalid trade type found for Trade No " + (i+1) + "\n");
            }
        }
        logValidationResults(errorsByTrade);
        return errorsByTrade;
    }

    private void logValidationResults(Map<String, List<String>> errorsByTrade) {
        errorsByTrade.forEach((trade, errors) -> {
            LOGGER.info("Validation results for " + trade);
            errors.forEach(LOGGER::info);
        });
    }
}
