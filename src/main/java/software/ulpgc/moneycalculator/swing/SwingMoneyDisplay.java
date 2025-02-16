package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.view.MoneyDisplay;
import software.ulpgc.moneycalculator.models.Money;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
