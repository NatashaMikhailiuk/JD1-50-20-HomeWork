package homeworkfour.taskstring;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        NumberUtils numberUtils = new NumberUtils();
        Scanner scanner = new Scanner(System.in);
        int numberPoint = getPoints(scanner);

        if (numberPoint == 1) {
            getIntNumberToString(numberUtils, scanner);
        }
        if (numberPoint == 2) {
            getDoubleNumberToString(numberUtils, scanner);
        }
        if (numberPoint == 3) {
            getNumberOfWeekToString(numberUtils, scanner);
        }
        if (numberPoint == 4) {
            getMillisecondsToString(numberUtils, scanner);
        }
        scanner.close();
    }

    private static int getPoints(Scanner scanner) {
        int numberPoint = -1;
        while (numberPoint <= 0 || numberPoint > 4) {
            try {
                printPoints();
                numberPoint = scanner.nextInt();
            } catch (InputMismatchException exception) {
                String wrongInput = scanner.nextLine();
                printException(wrongInput);
            }
        }
        return numberPoint;
    }

    private static void getIntNumberToString(NumberUtils numberUtils, Scanner scanner) {
        int value = -1;
        while (value < 0 || value > 999_999_999) {
            try {
                printNumber();
                printNumberAgain();
                value = scanner.nextInt();
            } catch (InputMismatchException exception) {
                String wrongInput = scanner.nextLine();
                printException(wrongInput);
            }
        }
        System.out.println(numberUtils.toStringInt(value));
    }

    private static void getDoubleNumberToString(NumberUtils numberUtils, Scanner scanner) {
        double value = -1;
        while (value < 0 || value > 999_999_999) {
            try {
                printNumber();
                printNumberAgain();
                value = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                String wrongInput = scanner.nextLine();
                printException(wrongInput);
            }
        }
        System.out.println(numberUtils.toStringDouble(value));
    }

    private static void getNumberOfWeekToString(NumberUtils numberUtils, Scanner scanner) {
        int value = -1;
        while (value < 0 || value > 365) {
            try {
                printNumber();
                System.out.println("The number should be no longer 365, try again...");
                value = scanner.nextInt();
            } catch (InputMismatchException exception) {
                String wrongInput = scanner.nextLine();
                printException(wrongInput);
            }
        }
        System.out.println(numberUtils.toWeek(value));
    }

    private static void getMillisecondsToString(NumberUtils numberUtils, Scanner scanner) {
        int pointNumber = -1;
        while (pointNumber < 0 || pointNumber > 2) {
            try {
                printPointsForTime();
                pointNumber = scanner.nextInt();
            } catch (InputMismatchException exception) {
                String wrongInput = scanner.nextLine();
                printException(wrongInput);
            }
        }
        if (pointNumber == 1) {
            long value = -1L;
            while (value < 0 || value > 999_999_999) {
                try {
                    printNumber();
                    value = scanner.nextLong();
                } catch (InputMismatchException exception) {
                    String wrongInput = scanner.nextLine();
                    printException(wrongInput);
                }
            }
            System.out.println(numberUtils.toHoursMinuteSecondMillisecond(value, true));
        }
        if (pointNumber == 2) {
            long value = -1;
            while (value < 0 || value > 999_999_999) {
                try {
                    printNumber();
                    value = scanner.nextLong();
                } catch (InputMismatchException exception) {
                    String wrongInput = scanner.nextLine();
                    printException(wrongInput);
                }
            }
            System.out.println(numberUtils.toHoursMinuteSecondMillisecond(value, false));
        }
    }

    private static void printPoints() {
        System.out.print("Choose the necessary point:\n 1 - if you wish to write the int number in letters; " +
                "\n 2 - if you wish to write the double number in letters; " +
                "\n 3 - if you wish to know the number of week;  " +
                "\n 4 - if you wish to know the time instead of milliseconds; " + "\n");
    }

    private static void printNumber() {
        System.out.println("Please, write the number: ");
    }

    private static void printNumberAgain() {
        System.out.print("The number should be no long 999 999 999, try again....");
    }

    private static void printPointsForTime() {
        System.out.println("1 - If you wish 00:00:00.000 format" +
                "\n2 - If you wish __hours__minutes__seconds__milliseconds format");
    }

    private static void printException(String wrongInput) {
        System.out.println("The input " + "\"" + wrongInput + "\"" + " is incorrect, try again....");
    }
}
