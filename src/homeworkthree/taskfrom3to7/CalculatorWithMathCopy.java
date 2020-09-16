package homeworkthree.taskfrom3to7;

import homeworkthree.ICalculator;

public class CalculatorWithMathCopy implements ICalculator {

    public double calcAddition(double a, double b) {
        return a + b;
    }

    public double calcSubtraction(double a, double b) {
        return a - b;
    }

    public double calcMultiplication(double a, double b) {
        return a * b;
    }

    public double calcDivision(double a, double b) {
        return a / b;
    }

    public double calcPower(double a, double b) {
        return Math.pow(a, b);
    }

    public double calcABS(double a) {
        return Math.abs(a);
    }

    public double calcSqrt(double a) {
        return Math.sqrt(a);
    }
}
