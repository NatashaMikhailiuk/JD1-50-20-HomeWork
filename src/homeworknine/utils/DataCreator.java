package homeworknine.utils;

import homeworksix.utils.creator.TextReader;
import java.io.File;
import java.util.Random;

public class DataCreator {
    private static final char[] ALL_CONSONANT_LETTERS_UPPER_CASE = ("МСЧЖДЛРПВФХЗЩШГНКЦ").toCharArray();
    private static final char[] ALL_CONSONANT_LETTERS_LOWER_CASE = ("мчждлрпвфхзщшгнкц").toCharArray();
    private static final char[] ALL_VOWEL_LETTERS_LOWER_CASE = ("яиюэоаыуе").toCharArray();
    private static final int[] NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final String RESOURCES_PATH = "homework" + File.separator + "resources" + File.separator;

    private static final Random rnd = new Random();

    public String createSurnameFromTheListOfLetters(int sizeUpperLetters, int sizeLowerLetters) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < sizeUpperLetters; i++) {
            builder1.append(ALL_CONSONANT_LETTERS_UPPER_CASE[rnd.nextInt(ALL_CONSONANT_LETTERS_UPPER_CASE.length)]);
        }

        for (int i = 0; i < sizeLowerLetters; i++) {
            builder2.append(ALL_VOWEL_LETTERS_LOWER_CASE[rnd.nextInt(ALL_VOWEL_LETTERS_LOWER_CASE.length)]);
            builder2.append(ALL_CONSONANT_LETTERS_LOWER_CASE[rnd.nextInt(ALL_CONSONANT_LETTERS_LOWER_CASE.length)]);
        }

        return builder1.append(builder2).toString();
    }

    public String createNameAndMiddleName() {
        String[] words = readFileToWordsArray("names.txt");
        return words[rnd.nextInt(51530)];
    }

    public int createMark() {
        int mark = 0;
        for (int i = 0; i < 1; i++) {
            mark = mark + NUMBERS[rnd.nextInt(NUMBERS.length)];
        }
        return mark;
    }

    private String[] readFileToWordsArray(String fileName) {
        String path = RESOURCES_PATH + fileName;
        path = TextReader.readAllBytesJava7(path);
        path = path.replace(",", "");
        return path.split("\\s+");
    }
}
