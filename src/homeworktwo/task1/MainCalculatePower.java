package homeworktwo.task1;

import java.util.Scanner;

public class MainCalculatePower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = getNumber1(scanner);
        double num2 = getNumber2(scanner);
        scanner.close();
        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);
        double result = Math.pow(num1, num2);
        System.out.println("Result: " + result);
    }

    static double getNumber1(Scanner scanner) {
        System.out.print("Input number 1: ");
        return scanner.nextDouble();
    }

    static double getNumber2(Scanner scanner) {
        System.out.print("Input number 2: ");
        double num = scanner.nextDouble();
        while (num < 0 || num * 10 % 10 != 0) {
            System.out.print("The number should be above zero and not fractional, try again....");
            System.out.print("Input number 2 again: ");
            num = scanner.nextDouble();
        }
        return num;
    }
}

