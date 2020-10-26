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
            boolean isValidPath = false;
            int count = 0;
            while (!isValidPath) {
                System.out.println("Please, write the path");
                path = SCANNER.next();
                File file = new File(path);
                if (file.exists()) {
                    path = path + File.separator + fileName;
                    isValidPath = true;
                    System.out.println("The File path and name is : " + path);
                }
                if (!file.exists()) {
                    if (count < 4) {
                        System.out.println(path + " is not valid");
                        count++;
                    } else {
                        System.out.println("The path still is not correct, the programme has finished work");
                        System.exit(1);
                    }
                }
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

