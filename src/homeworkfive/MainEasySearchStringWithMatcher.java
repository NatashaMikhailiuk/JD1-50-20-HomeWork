package homeworkfive;

import java.io.File;

public class MainEasySearchStringWithMatcher {
    public static void main(String[] args) {
        EasySearchStringWithMatcher searchWord = new EasySearchStringWithMatcher();
        String path = "homework" + File.separator + "resources" + File.separator;
        String text = path + "Война и мир_книга.txt";
        text = MainWarAndPeace.readAllBytesJava7(text);
        String word1 = "война";
        String word2 = "мир";
        String word3 = "и";
        printResult(searchWord, text, word1);
        printResult(searchWord, text, word2);
        printResult(searchWord, text, word3);

    }

    private static void printResult(EasySearchStringWithMatcher searchWord, String text, String word) {
        long numberOfTimes = searchWord.search(text, word);
        System.out.println("Слово " + "\"" + word + "\"" + " найдено " + numberOfTimes + " раз(а)");
    }
}
