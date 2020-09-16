package homeworkthree.taskfrom3to7;

import homeworkthree.ICalculator;
import homeworkthree.taskfrom1to2.CalculatorWithOperator;

public class CalculatorWithMathExtends extends CalculatorWithOperator implements ICalculator {

    @Override
    public double calcPower(double a, double b) {
        return Math.pow(a, b);
    }

    @Override
    public double calcABS(double a) {
        return Math.abs(a);
    }

    @Override
    public double calcSqrt(double a) {
        return Math.sqrt(a);
    }
}
