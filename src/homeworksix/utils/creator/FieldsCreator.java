package homeworksix.utils.creator;

import java.io.File;
import java.util.Random;

public class FieldsCreator {
    private static final char[] allLettersUpperCase = ("ZXCVBNMASDFGHJKLQWERTYUIOP").toCharArray();
    private static final char[] allLettersLowerCase = ("zxcvbnmasdfghjklqwertyuiop").toCharArray();
    private static final char[] allChar = ("ZXCVBNMASDFGHJKLQWERTYUIOP0123456789").toCharArray();
    private static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final String RESOURCES_PATH = "homework" + File.separator + "resources" + File.separator;


    private static final Random rnd = new Random();
    StringBuilder builder1 = new StringBuilder();
    StringBuilder builder2 = new StringBuilder();


    public String createNickFromTheListOfLetters(int lengthFirst, int lengthSecond) {
        for (int i = 0; i < lengthFirst; i++) {
            builder1.append(allLettersUpperCase[rnd.nextInt(allLettersUpperCase.length)]);
        }
        for (int i = 0; i < lengthSecond; i++) {
            builder2.append(allLettersLowerCase[rnd.nextInt(allLettersLowerCase.length)]);
        }
        StringBuilder nick = builder1.append(builder2);
        return nick.toString();
    }

    public String createPassword(int lengthChar) {
        if (lengthChar < 3) {
            lengthChar = 3;
            for (int i = 0; i < lengthChar; i++) {
                builder1.append(allChar[rnd.nextInt(allChar.length)]);
            }
        } else {
            for (int i = 0; i < lengthChar; i++) {
                builder1.append(allChar[rnd.nextInt(allChar.length)]);
            }
        }
        StringBuilder password = builder1;
        return password.toString();
    }

    public String createNickFromListOfNames() {
        String[] words = readFileToWordsArray("names.txt");
        return words[rnd.nextInt(51530)];
    }

    public int createAge() {
        int age = 0;
        for (int i = 0; i < 1; i++) {
            age = age + numbers[rnd.nextInt(numbers.length)];
        }
        return age;
    }

    public String createNameForPetFromTheListOfNames() {
        String[] words = readFileToWordsArray("pet_niks.txt");
        return words[rnd.nextInt(1330)];
    }

    private String[] readFileToWordsArray(String fileName) {
        String path = RESOURCES_PATH + fileName;
        path = TextReader.readAllBytesJava7(path);
        path = path.replace(",", "");
        String[] words = path.split("\\s+");
        return words;
    }
}
