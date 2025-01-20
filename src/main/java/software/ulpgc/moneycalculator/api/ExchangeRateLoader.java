package software.ulpgc.moneycalculator.api;

import software.ulpgc.moneycalculator.models.Currency;
import software.ulpgc.moneycalculator.models.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
