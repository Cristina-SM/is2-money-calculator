package software.ulpgc.moneycalculator.view;

import software.ulpgc.moneycalculator.models.Currency;
import software.ulpgc.moneycalculator.models.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
