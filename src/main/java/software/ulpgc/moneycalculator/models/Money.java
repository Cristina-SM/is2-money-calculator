package software.ulpgc.moneycalculator.models;

public record Money(long amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
