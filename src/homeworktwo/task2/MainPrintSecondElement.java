package homeworktwo.task2;

import java.util.Scanner;

public class MainPrintSecondElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Input the number: ");
            array[i] = scanner.nextInt();
        }
        for (int i = 1; i < array.length; ) {
            System.out.println("Элемент № " + i + ": " + array[i]);
            i += 2;
        }
    }
}
