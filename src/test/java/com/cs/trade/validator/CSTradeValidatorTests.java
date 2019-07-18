package com.cs.trade.validator;

import com.cs.trade.validator.enums.TradeType;
import com.cs.trade.validator.factory.TradeValidatorFactory;
import com.cs.trade.validator.model.ForwardTrade;
import com.cs.trade.validator.model.SpotTrade;
import com.cs.trade.validator.model.ValidationError;
import com.cs.trade.validator.model.VanillaOptionTrade;
import com.cs.trade.validator.validators.TradeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CSTradeValidatorTests {

	@Test
	public void testSpotTradeValidationForValidTrade() {
		SpotTrade spotTrade = new SpotTrade(TradeType.SPOT_TRADE);
		spotTrade.setCustomer("PLUTO1");
		spotTrade.setCcyPair("EURUSD");
		spotTrade.setTradeDate(LocalDate.parse("2016-08-11"));
		spotTrade.setValueDate(LocalDate.parse("2016-08-15"));
		TradeValidator validator = TradeValidatorFactory.INSTANCE.getTradeValidator(spotTrade);
		List<ValidationError> validationErrors = validator.validateTrade();
		assertThat(validationErrors, hasSize(0));
	}

	@Test
	public void testSpotTradeValidationForInValidTrade() {
		SpotTrade spotTrade = new SpotTrade(TradeType.SPOT_TRADE);
		spotTrade.setCustomer("XPLUTO1");
		spotTrade.setCcyPair("EUXUSD");
		spotTrade.setTradeDate(LocalDate.parse("2016-08-21"));
		spotTrade.setValueDate(LocalDate.parse("2016-08-15"));
		TradeValidator validator = TradeValidatorFactory.INSTANCE.getTradeValidator(spotTrade);
		List<ValidationError> validationErrors = validator.validateTrade();
		assertThat(validationErrors, hasSize(3));
		assertThat(validationErrors, containsInAnyOrder(
				ValidationError.INVALID_VALUE_DATE_AND_TRADE_DATE_ORDER,
				ValidationError.INVALID_COUNTER_PARTY,
				ValidationError.INVALID_CURRENCY_CODE_PAIR));
	}

	@Test
	public void testForwardTradeValidationForValidTrade() {
		ForwardTrade forwardTrade = new ForwardTrade(TradeType.FORWARD_TRADE);
		forwardTrade.setCustomer("PLUTO2");
		forwardTrade.setCcyPair("EURUSD");
		forwardTrade.setTradeDate(LocalDate.parse("2016-08-11"));
		forwardTrade.setValueDate(LocalDate.parse("2016-08-22"));
		TradeValidator validator = TradeValidatorFactory.INSTANCE.getTradeValidator(forwardTrade);
		List<ValidationError> validationErrors = validator.validateTrade();
		assertThat(validationErrors, hasSize(0));
	}

	@Test
	public void testForwardTradeValidationForInValidTrade() {
		ForwardTrade forwardTrade = new ForwardTrade(TradeType.FORWARD_TRADE);
		forwardTrade.setCustomer("YPLUTO2");
		forwardTrade.setCcyPair("EURYUSD");
		forwardTrade.setTradeDate(LocalDate.parse("2016-08-23"));
		forwardTrade.setValueDate(LocalDate.parse("2016-08-22"));
		TradeValidator validator = TradeValidatorFactory.INSTANCE.getTradeValidator(forwardTrade);
		List<ValidationError> validationErrors = validator.validateTrade();
		assertThat(validationErrors, hasSize(3));
		assertThat(validationErrors, containsInAnyOrder(
				ValidationError.INVALID_VALUE_DATE_AND_TRADE_DATE_ORDER,
				ValidationError.INVALID_COUNTER_PARTY,
				ValidationError.INVALID_CURRENCY_CODE_PAIR));
	}

	@Test
	public void testOptionTradeValidationForValidTrade() {
		VanillaOptionTrade optionTrade = new VanillaOptionTrade(TradeType.VANILLA_OPTION_TRADE);
		optionTrade.setCustomer("PLUTO1");
		optionTrade.setCcyPair("EURUSD");
		optionTrade.setTradeDate(LocalDate.parse("2016-08-11"));
		optionTrade.setDeliveryDate(LocalDate.parse("2016-08-22"));
		optionTrade.setPayCcy("USD");
		optionTrade.setPremiumCcy("USD");
		optionTrade.setStyle("EUROPEAN");
		optionTrade.setExpiryDate(LocalDate.parse("2016-08-19"));
		optionTrade.setPremiumDate(LocalDate.parse("2016-08-12"));

		TradeValidator validator = TradeValidatorFactory.INSTANCE.getTradeValidator(optionTrade);
		List<ValidationError> validationErrors = validator.validateTrade();
		assertThat(validationErrors, hasSize(0));
	}

	@Test
	public void testOptionTradeValidationForInValidTrade() {
		VanillaOptionTrade optionTrade = new VanillaOptionTrade(TradeType.VANILLA_OPTION_TRADE);
		optionTrade.setCustomer("PLUTO1");
		optionTrade.setCcyPair("EURUSD");
		optionTrade.setTradeDate(LocalDate.parse("2016-08-23"));
		optionTrade.setDeliveryDate(LocalDate.parse("2016-08-22"));
		optionTrade.setPayCcy("UXD");
		optionTrade.setPremiumCcy("UYD");
		optionTrade.setStyle("EUROPEAN");
		optionTrade.setExpiryDate(LocalDate.parse("2016-08-19"));
		optionTrade.setPremiumDate(LocalDate.parse("2016-08-12"));

		TradeValidator validator = TradeValidatorFactory.INSTANCE.getTradeValidator(optionTrade);
		List<ValidationError> validationErrors = validator.validateTrade();
		assertThat(validationErrors, hasSize(3));
		assertThat(validationErrors, containsInAnyOrder(
				ValidationError.INVALID_DELIVERY_DATE_AND_TRADE_DATE_ORDER,
				ValidationError.INVALID_CURRENCY_CODE_PAYCCY,
				ValidationError.INVALID_CURRENCY_CODE_PREMIUMCCY));
	}
}
