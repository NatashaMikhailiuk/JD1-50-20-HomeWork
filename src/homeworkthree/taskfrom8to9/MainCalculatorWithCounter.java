package homeworkthree.taskfrom8to9;

import homeworkthree.ICalculator;
import homeworkthree.taskfrom1to2.CalculatorWithOperator;
import homeworkthree.taskfrom3to7.CalculatorWithMathCopy;
import homeworkthree.taskfrom3to7.CalculatorWithMathExtends;

public class MainCalculatorWithCounter {
    public static void main(String[] args) {
        ICalculator calcOperator = new CalculatorWithOperator();
        ICalculator calcMathCopy = new CalculatorWithMathCopy();
        ICalculator calcExtends = new CalculatorWithMathExtends();
        CalculatorWithCounter calcCounter = new CalculatorWithCounter(calcOperator, calcMathCopy, calcExtends);
        double result = calcCounter.calcAddition(4.1, calcCounter.calcAddition(calcCounter.calcMultiplication(15, 7),
                calcCounter.calcPower(calcCounter.calcDivision(28, 5), 2)));
        System.out.format("Result 4.1 + 15 * 7 + (28 / 5) ^2= %.3f%n", result);
        System.out.println("Number of operations are: " + (calcCounter.getCountOperation()));
        int divisor = 0;
        double divisorD = 0.0D;
        double resultDivisionZero = result / divisor;
        double resultDivisionZeroD = result / divisorD;
        System.out.println("Result of division at 0 = " + resultDivisionZero);
        System.out.println("Result of division at 0.0D = " + resultDivisionZeroD);
    }
}
