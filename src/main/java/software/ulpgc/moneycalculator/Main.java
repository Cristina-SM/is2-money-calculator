package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.api.APICurrencyLoader;
import software.ulpgc.moneycalculator.control.Command;
import software.ulpgc.moneycalculator.control.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.mocks.MockExchangeRateLoader;
import software.ulpgc.moneycalculator.models.Currency;
import software.ulpgc.moneycalculator.swing.SwingCurrencyDialog;
import software.ulpgc.moneycalculator.swing.SwingMoneyDialog;
import software.ulpgc.moneycalculator.swing.SwingMoneyDisplay;
import software.ulpgc.moneycalculator.view.CurrencyDialog;
import software.ulpgc.moneycalculator.view.MoneyDialog;
import software.ulpgc.moneycalculator.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public static void main(String[] args) {
        Main main = new Main();
        List<Currency> currencies = new APICurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new MockExchangeRateLoader(),
                main.moneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }

    public Main() throws HeadlessException {
        this.setTitle("Money calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(createMoneyDisplay());
        this.add(toolbar());
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}
