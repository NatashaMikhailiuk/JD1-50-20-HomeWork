package homeworkthree.taskfrom1to2;

import homeworkthree.ICalculator;

public class CalculatorWithOperator implements ICalculator {

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
        double result = a;
        for (int i = 1; i < b; i++) {
            if (i < b) {
                result = result * a;
            }
        }
        return result;
    }

    public double calcABS(double a) {
        return (a <= 0.00D) ? -a : a;
    }

    public double calcSqrt(double a) {
        double t;
        double squareroot = a / 2;
        do {
            t = squareroot;
            squareroot = (t + (a / t)) / 2;
        }
        while ((t - squareroot) != 0);
        return squareroot;
    }
}
