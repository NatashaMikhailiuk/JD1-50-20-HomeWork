package homeworkfive;

import java.io.File;

public class MainEasySearch {
    public static void main(String[] args) {
        String path = "homework" + File.separator + "resources" + File.separator;

        String text = path + "война и мир_книга.txt";
        text = MainWarAndPeace.readAllBytesJava7(text);
        String word1 = "война";
        String word2 = "мир";
        String word3 = "и";
        printResult(text, word1);
        printResult(text, word2);
        printResult(text, word3);
    }

    private static void printResult(String text, String word) {
        EasySearch searchWord = new EasySearch();
        long numberOfTimes = searchWord.search(text, word);
        System.out.println("Слово " + "\"" + word + "\"" + " найдено " + numberOfTimes + " раз(а)");
    }
}
