package homeworkthree.taskfrom8to9;


import homeworkthree.ICalculator;

public class CalculatorWithCounter implements ICalculator {
    private final ICalculator calc1;
    private final ICalculator calc2;
    private final ICalculator calc3;
    private int countOfOperations = 0;

    public CalculatorWithCounter(ICalculator calc1, ICalculator calc2,
                                 ICalculator calc3) {
        this.calc1 = calc1;
        this.calc2 = calc2;
        this.calc3 = calc3;
    }

    public double calcAddition(double a, double b) {
        countOfOperations++;
        return calc1.calcAddition(a, b);
    }

    public double calcSubtraction(double a, double b) {
        countOfOperations++;
        return calc2.calcSubtraction(a, b);
    }

    public double calcMultiplication(double a, double b) {
        countOfOperations++;
        return calc3.calcMultiplication(a, b);
    }

    public double calcDivision(double a, double b) {
        countOfOperations++;
        return calc3.calcDivision(a, b);
    }

    public double calcPower(double a, double b) {
        countOfOperations++;
        return calc2.calcPower(a, b);
    }

    public double calcABS(double a) {
        countOfOperations++;
        return calc3.calcABS(a);
    }

    public double calcSqrt(double a) {
        countOfOperations++;
        return calc2.calcSqrt(a);
    }

    public int getCountOperation() {
        return countOfOperations;
    }
}
