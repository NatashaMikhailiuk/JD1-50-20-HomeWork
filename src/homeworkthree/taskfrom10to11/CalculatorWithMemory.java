package homeworkthree.taskfrom10to11;

import homeworkthree.ICalculator;
import homeworkthree.taskfrom8to9.CalculatorWithCounter;

public class CalculatorWithMemory extends CalculatorWithCounter implements ICalculator {
    private double memory = 0;
    private double lastCalculationResult = 0;

    public CalculatorWithMemory(ICalculator calc1, ICalculator calc2, ICalculator calc3) {
        super(calc1, calc2, calc3);
    }

    @Override
    public double calcAddition(double a, double b) {
        lastCalculationResult = super.calcAddition(a, b);
        return lastCalculationResult;
    }

    @Override
    public double calcSubtraction(double a, double b) {
        lastCalculationResult = super.calcSubtraction(a, b);
        return lastCalculationResult;
    }

    @Override
    public double calcMultiplication(double a, double b) {
        lastCalculationResult = super.calcMultiplication(a, b);
        return lastCalculationResult;
    }

    @Override
    public double calcDivision(double a, double b) {
        lastCalculationResult = super.calcDivision(a, b);
        return lastCalculationResult;
    }

    @Override
    public double calcPower(double a, double b) {
        lastCalculationResult = super.calcPower(a, b);
        return lastCalculationResult;
    }

    @Override
    public double calcABS(double a) {
        lastCalculationResult = super.calcABS(a);
        return lastCalculationResult;
    }

    @Override
    public double calcSqrt(double a) {
        lastCalculationResult = super.calcSqrt(a);
        return lastCalculationResult;
    }

    public void saveMemory() {
        memory = lastCalculationResult;
    }

    public double getMemory() {
        double temp = memory;
        memory = 0;
        return temp;
    }
}
