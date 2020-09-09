package homeworktwo.task2;

import java.util.Scanner;

public class MainPrintAllLoop {
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
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("\n ");
        System.out.print("Массив элементов вывод через do...while: ");
        int k = 0;
        do {
            System.out.print(" " + array[k]);
            k++;
        }
        while (k < array.length);
        System.out.println("\n ");
        System.out.print("Массив элементов вывод через while: ");
        int j = 0;
        while (j < array.length) {
            System.out.print(" " + array[j]);
            j++;
        }
        System.out.println("\n ");
        System.out.print("Массив элементов вывод через foreach: ");
        for (int element : array) {
            System.out.print(" " + element);
        }
    }
}
