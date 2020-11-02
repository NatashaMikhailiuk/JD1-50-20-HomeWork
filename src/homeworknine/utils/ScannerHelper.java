package homeworknine.utils;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerHelper {

    String fileName;

    public ScannerHelper(String fileName) {
        this.fileName = fileName;
    }

    public static String scanFromConsole(Scanner scanner, String fileName) {
        int decisionOfUser = -1;
        String path = "";
        while (decisionOfUser <= 0 || decisionOfUser > 2)
            try {
                System.out.println("If you knew the path for reading file, please write 1 if won't, write 2");
                decisionOfUser = scanner.nextInt();
            } catch (InputMismatchException exception) {
                String wrongInput = scanner.nextLine();
                printException(wrongInput);
            }
        if (decisionOfUser == 1) {
            boolean isValidPath = false;
            int count = 0;
            while (!isValidPath) {
                System.out.println("Please, write the path");
                path = scanner.next();
                File file = new File(path);
                if (file.exists()) {
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
            path = fileName;
            File file = new File(path);
            if(file.exists()){
                System.out.println("The File path and name is : " + path);
            }else{
                try {
                    path = fileName;
                    System.out.println("The File name is : " + path);
                } catch (InputMismatchException exception) {
                    String wrongInput = scanner.nextLine();
                    printException(wrongInput);
                }
            }
        }
        scanner.close();
        return path;
    }

    private static void printException(String wrongInput) {
        System.out.println("The input " + "\"" + wrongInput + "\"" + " is incorrect, try again....");
    }
}
