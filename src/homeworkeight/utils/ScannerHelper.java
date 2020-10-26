package homeworkeight.utils;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerHelper {

    static private final Scanner SCANNER = new Scanner(System.in);
    String fileName;

    public ScannerHelper(String fileName) {
        this.fileName = fileName;
    }

    public static String scannerHelper(String fileName) {
        int decisionOfUser = -1;
        String path = "";
        while (decisionOfUser <= 0 || decisionOfUser > 2)
            try {
                System.out.println("If you prefer to indicate the path of File, write 1, if won't, write 2");
                decisionOfUser = SCANNER.nextInt();
            } catch (InputMismatchException exception) {
                String wrongInput = SCANNER.nextLine();
                printException(wrongInput);
            }
        if (decisionOfUser == 1) {
            try {
                System.out.println("Please, write the path");
                path = SCANNER.next() + File.separator + fileName;
                System.out.println("The File path and name is : " + path);
            } catch (InputMismatchException exception) {
                String wrongInput = SCANNER.nextLine();
                printException(wrongInput);

            }
        }
        if (decisionOfUser == 2) {
            try {
                path = fileName;
                System.out.println("The File name is : " + path);
            } catch (InputMismatchException exception) {
                String wrongInput = SCANNER.nextLine();
                printException(wrongInput);
            }
        }
        SCANNER.close();
        return path;
    }

    private static void printException(String wrongInput) {
        System.out.println("The input " + "\"" + wrongInput + "\"" + " is incorrect, try again....");
    }
}

