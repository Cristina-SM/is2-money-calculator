package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.models.Currency;
import software.ulpgc.moneycalculator.models.ExchangeRate;
import software.ulpgc.moneycalculator.api.ExchangeRateLoader;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, LocalDate.now(), 1.218);
    }
}
