package homeworkfive;

public class MainEasySearchStringWithMatcher {
    public static void main(String[] args) {
        String text = "C:/it-academy/home work/task 5/Война и мир_книга.txt";
        text = MainWarAndPeace.readAllBytesJava7(text);
        String word1 = "война";
        String word2 = "мир";
        String word3 = "и";
        printResult(text, word1);
        printResult(text, word2);
        printResult(text, word3);

    }

    private static void printResult(String text, String word) {
        EasySearchStringWithMatcher searchWord = new EasySearchStringWithMatcher();
        long numberOfTimes = searchWord.search(text, word);
        System.out.println("Слово " + "\"" + word + "\"" + " найдено " + numberOfTimes + " раз(а)");
    }
}
