package homeworktwo.task4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //сортировка массива при помощи пузырьковой сортировки
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {1, 1, 1, 1};
        int[] array3 = {9, 1, 5, 99, 9, 9};
        int[] array4 = {};
        printAndBubbleSort(array1);
        printAndBubbleSort(array2);
        printAndBubbleSort(array3);
        printAndBubbleSort(array4);

        // сортировка массива при помощи шейкерной сортировки
        int[] array5 = {1, 2, 3, 4, 5, 6};
        int[] array6 = {1, 1, 1, 1};
        int[] array7 = {9, 1, 5, 99, 9, 9};
        int[] array8 = {};
        printAndCocktailSort(array5);
        printAndCocktailSort(array6);
        printAndCocktailSort(array7);
        printAndCocktailSort(array8);

        // создание массива рандомной длины и рандомных чисел
        int[] randomArray1 = createRandomArray();
        printAndBubbleSort(randomArray1);
        int[] randomArray2 = createRandomArray();
        printAndCocktailSort(randomArray2);

        //создание массива через ввод из консоли
        int[] arrayFromScanner1 = createConsoleArray();
        printAndBubbleSort(arrayFromScanner1);
        int[] arrayFromScanner2 = createConsoleArray();
        printAndCocktailSort(arrayFromScanner2);
    }

    public static void printAndCocktailSort(int[] arr) {
        System.out.print(Arrays.toString(arr) + "   -->   ");
        ArraySorter.cocktailSortMethod(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void printAndBubbleSort(int[] arr) {
        System.out.print(Arrays.toString(arr) + "   -->   ");
        ArraySorter.bubbleMethod(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] createRandomArray() {
        Random rnd = new Random();
        int randomSize = rnd.nextInt(10);
        int[] randomArray = new int[randomSize];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rnd.nextInt(50);
        }
        return randomArray;
    }

    public static int[] createConsoleArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the size of array:");
        int sizeFromScanner = scanner.nextInt();
        int[] arrayFromScanner = new int[sizeFromScanner];
        for (int f = 0; f < arrayFromScanner.length; f++) {
            System.out.print("Input the number: ");
            arrayFromScanner[f] = scanner.nextInt();
        }
        return arrayFromScanner;
    }
}

