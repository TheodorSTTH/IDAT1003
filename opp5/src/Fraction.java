public class Fraction {
    private double numerator;
    private double denominator;
    public Fraction(double numerator, double denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Nevner kan ikke være 0");
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(double numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
    public double getNumerator() {
        return this.numerator;
    }
    public double getDenominator() {
        return this.denominator;
    }
    public void printFraction() {
        System.out.println(this.numerator + " / " + this.denominator);
    }
    public void sumWithOtherFraction(Fraction other) {
        final double outNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        final double outDenominator = other.denominator * this.denominator;
        this.numerator = outNumerator;
        this.denominator = outDenominator;
        this.printFraction();
    }
    public void subtractOtherFraction(Fraction other) {
        final double outNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        final double outDenominator = other.denominator * this.denominator;
        this.numerator = outNumerator;
        this.denominator = outDenominator;
        this.printFraction();
    }
    public void multiplyWithOtherFraction(Fraction other) {
        final double outNumerator = this.numerator * other.numerator;
        final double outDenominator = other.denominator * this.denominator;
        this.numerator = outNumerator;
        this.denominator = outDenominator;
        this.printFraction();
    }
    public void divideWithOtherFraction(Fraction other) {
        final double outNumerator = this.numerator * other.denominator;
        final double outDenominator = this.denominator * other.numerator;
        this.numerator = outNumerator;
        this.denominator = outDenominator;
        this.printFraction();
    }
}