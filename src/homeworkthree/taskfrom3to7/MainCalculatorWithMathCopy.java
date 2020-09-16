package homeworkthree.taskfrom3to7;

public class MainCalculatorWithMathCopy {
    public static void main(String[] args) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        double result = calc.calcAddition(4.1, calc.calcAddition(calc.calcMultiplication(15, 7),
                calc.calcPower(calc.calcDivision(28, 5), 2)));
        System.out.format("Result 4.1 + 15 * 7 + (28 / 5) ^2= %.3f%n", result);
        int divisor = 0;
        double divisorD = 0.0D;
        double resultDivisionZero = result / divisor;
        double resultDivisionZeroD = result / divisorD;
        System.out.println("Result of division at 0 = " + resultDivisionZero);
        System.out.println("Result of division at 0.0D = " + resultDivisionZeroD);
    }
}
