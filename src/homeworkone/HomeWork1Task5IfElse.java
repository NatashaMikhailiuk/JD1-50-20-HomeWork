package homeworkone;

import java.util.Scanner;

public class HomeWork1Task5IfElse {
    public static void main(String[] arg) {
        String name1 = "Вася";
        String name2 = "Анастасия";
        Scanner in = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = in.nextLine().trim();
        System.out.printf("Name: %s \n", name);
        in.close();
        if (name1.equalsIgnoreCase(name)) {
            System.out.println("Привет" + '\n' + "Я тебя так долго ждал");
        } else if (name2.equalsIgnoreCase(name)) {
            System.out.println("Я тебя так долго ждал");
        } else {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}
