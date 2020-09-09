package homeworktwo.task2;

import java.util.Scanner;

public class MainPrintAllLoopReversed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Input the number: ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Массив элементов вывод через for: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(" " + array[i]);
        }
        System.out.println("\n ");
        System.out.print("Массив элементов вывод через do...while: ");
        int k = array.length - 1;
        do {
            System.out.print(" " + array[k]);
            k--;
        }
        while (k >= 0);
        System.out.println("\n ");
        System.out.print("Массив элементов вывод через while: ");
        int j = array.length - 1;
        while (j >= 0) {
            System.out.print(" " + array[j]);
            j--;
        }
        System.out.println("\n ");
        System.out.print("Массив элементов вывод через foreach: ");
        int[] arrReversed = new int[size];
        for (int i = 0; i < array.length; i++) {
            arrReversed[i] = array[array.length - (i + 1)];
        }
        for (int element : arrReversed) {
            System.out.print(" " + element);
        }
    }
}
