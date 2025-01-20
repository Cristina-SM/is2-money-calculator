package software.ulpgc.moneycalculator.api;

import software.ulpgc.moneycalculator.models.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
