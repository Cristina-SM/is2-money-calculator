package software.ulpgc.moneycalculator.control;

import software.ulpgc.moneycalculator.api.ExchangeRateLoader;
import software.ulpgc.moneycalculator.models.Currency;
import software.ulpgc.moneycalculator.models.ExchangeRate;
import software.ulpgc.moneycalculator.models.Money;
import software.ulpgc.moneycalculator.view.CurrencyDialog;
import software.ulpgc.moneycalculator.view.MoneyDialog;
import software.ulpgc.moneycalculator.view.MoneyDisplay;

public class ExchangeMoneyCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money((long) (money.amount()*exchangeRate.rate()), currency);

        moneyDisplay.show(result);
    }
}
