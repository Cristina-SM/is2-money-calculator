package software.ulpgc.moneycalculator.models;

public record Currency(String code, String name) {
    @Override
    public String toString() {
        return code + "-" + name;
    }
}
