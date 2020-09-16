package homeworkthree.taskfrom10to11;


import homeworkthree.ICalculator;
import homeworkthree.taskfrom1to2.CalculatorWithOperator;
import homeworkthree.taskfrom3to7.CalculatorWithMathCopy;
import homeworkthree.taskfrom3to7.CalculatorWithMathExtends;

public class MainCalculatorWithMemory {
    public static void main(String[] args) {
        ICalculator calcOperator = new CalculatorWithOperator();
        ICalculator calcMathCopy = new CalculatorWithMathCopy();
        ICalculator calcExtends = new CalculatorWithMathExtends();
        CalculatorWithMemory calcMemory = new CalculatorWithMemory(calcOperator, calcMathCopy, calcExtends);
        calcMemory.calcDivision(28, 5);
        calcMemory.saveMemory();
        calcMemory.calcPower(calcMemory.getMemory(), 2);
        calcMemory.saveMemory();
        calcMemory.calcAddition(calcMemory.calcMultiplication(15, 7), calcMemory.getMemory());
        calcMemory.saveMemory();
        double result = calcMemory.calcAddition(4.1, calcMemory.getMemory());
        System.out.format("Total result = %.3f%n", result);
        System.out.println("Number of operations are: " + calcMemory.getCountOperation());
    }
}
