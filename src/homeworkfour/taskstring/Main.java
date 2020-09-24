package homeworkfour.taskstring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NumberUtils str = new NumberUtils();
        int num1;
        double num2;
        int num3;
        long num4;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose the correct point:\n 1 - if you wish to write the int number in letters; " +
                "\n 2 - if you wish to write the double number in letters; " +
                "\n 3 - if you wish to know the number of week;  " +
                "\n 4 - if you wish to know the time instead of milliseconds; " + "\n");
        int num = scanner.nextInt();
        while (num > 4) {
            System.out.print("You should choose the correct point, try again...." + "\n");
            System.out.print("Input the number of point: ");
            num = scanner.nextInt();
        }
        if (num == 1) {
            print();
            num1 = scanner.nextInt();
            while (num1 > 999_999_999) {
                System.out.print("The number should be no longer 999 999 999, try again...." + "\n");
                print();
                num1 = scanner.nextInt();
            }
            System.out.println(str.toStringInt(num1));
        }
        if (num == 2) {
            print();
            num2 = scanner.nextDouble();
            while (num2 > 999_999_999) {
                System.out.print("The number should be no longer 999 999 999.999999999, try again...." + "\n");
                print();
                num2 = scanner.nextDouble();
            }
            System.out.println(str.toStringDouble(num2));
        }
        if (num == 3) {
            print();
            num3 = scanner.nextInt();
            while (num3 > 365) {
                System.out.print("The number should be no longer 365, try again...." + "\n");
                print();
                num3 = scanner.nextInt();
            }
            System.out.println(str.toWeek(num3));
        }
        if (num == 4) {
            System.out.println("1 - If you wish 00:00:00.000 format" +
                    "\n2 - If you wish __hours__minutes__seconds__milliseconds format");
            int num5 = scanner.nextInt();
            while (num5 > 2) {
                System.out.print("You should choose the correct point, try again...." + "\n");
                System.out.print("Input the number of point: ");
                num5 = scanner.nextInt();
            }
            if (num5 == 1) {
                print();
                num4 = scanner.nextLong();
                System.out.println(str.toHoursMinuteSecondMillisecond(num4, true));
            }
            if (num5 == 2) {
                print();
                num4 = scanner.nextLong();
                System.out.println(str.toHoursMinuteSecondMillisecond(num4, false));
            }
        }
    }

    public static void print() {
        System.out.println("Please, write the number: ");
    }
}
