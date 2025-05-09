package Utils;

public class Percentage {

    private double value;

    public Percentage(double value) {
        setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Percentage value must be between 0 and 100.");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "%";
    }
}
