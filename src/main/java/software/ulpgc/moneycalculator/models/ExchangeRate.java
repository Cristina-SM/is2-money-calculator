package software.ulpgc.moneycalculator.models;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date, double rate) {
}
