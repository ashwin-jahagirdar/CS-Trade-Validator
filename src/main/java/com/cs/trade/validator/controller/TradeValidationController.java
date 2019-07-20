package com.cs.trade.validator.controller;

import com.cs.trade.validator.factory.TradeFactory;
import com.cs.trade.validator.factory.TradeValidatorFactory;
import com.cs.trade.validator.model.RawTradeInput;
import com.cs.trade.validator.model.Trade;
import com.cs.trade.validator.validators.TradeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import static java.util.stream.Collectors.toList;

@RestController
public class TradeValidationController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path= "/validate-trade", consumes = "application/json", produces = "application/json")
    public List<String> validateTrade(@RequestBody RawTradeInput rawTrade) {
        Optional<Trade> trade = TradeFactory.INSTANCE.getTrade(rawTrade);
        List<String> validationResult;
        if (trade.isPresent()) {
            validationResult = validateTrade(trade.get());
        } else {
            validationResult = Collections.singletonList("Invalid trade type found, skipping validation");
        }
        validationResult.forEach(LOGGER::info);
        return validationResult;
    }

    @PostMapping(path= "/validate-trades", consumes = "application/json", produces = "application/json")
    public Map<String, List<String>> validateTrades(@RequestBody List<RawTradeInput> rawTrades) {
        List<Optional<Trade>> trades = rawTrades
                .stream()
                .map(rawTradeInput -> TradeFactory.INSTANCE.getTrade(rawTradeInput))
                .collect(toList());
        Map<String, List<String>> errorsByTrade = new LinkedHashMap<>();

        for (int i=0; i<trades.size(); ++i) {
            Optional<Trade> trade = trades.get(i);
            if (trade.isPresent()) {
                errorsByTrade.put("Trade No " + (i + 1), validateTrade(trade.get()));
            } else {
                errorsByTrade.put("Trade No " + (i + 1),
                        Collections.singletonList(String.format("Invalid trade type found for Trade No %s, skipping validation", (i+1))));
            }
        }
        logValidationResults(errorsByTrade);
        return errorsByTrade;
    }

    private List<String> validateTrade(Trade trade) {
        TradeValidator tradeValidator = TradeValidatorFactory.INSTANCE.getTradeValidator(trade);
        List<String> validationResults = tradeValidator.validateTrade()
                .stream()
                .map(validationError -> validationError.getFields() + " - " + validationError.getErrorMessage())
                .collect(toList());
        if (validationResults.isEmpty()) {
            validationResults.add("Validation successful");
        }
        return validationResults;
    }

    private void logValidationResults(Map<String, List<String>> errorsByTrade) {
        errorsByTrade.forEach((trade, errors) -> {
            LOGGER.info("Validation results for " + trade);
            errors.forEach(LOGGER::info);
        });
    }
}
