package homeworkone;

import java.util.Scanner;

public class HomeWork1Task5Switch {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = in.nextLine().trim();
        System.out.printf("Name: %s \n", name);
        in.close();
        switch (name) {
            case "Вася":
                System.out.println("Привет" + '\n' + "Я тебя так долго ждал");
                break;
            case "Анастасия":
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
        }
    }
}
