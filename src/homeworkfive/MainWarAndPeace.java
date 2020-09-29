package homeworkfive;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MainWarAndPeace {
    public static void main(String[] args) {
        String fileWarAndPeace = "C:/it-academy/home work/task 5/Война и мир_книга.txt";
        fileWarAndPeace = readAllBytesJava7(fileWarAndPeace);
        fileWarAndPeace = fileWarAndPeace.replaceAll("\\s{2,}", " ");
        fileWarAndPeace = fileWarAndPeace.replaceAll("([.,^=:'*;!?\"()]+)|([a-zA-Z]+)|([-]{2,})", "");
        fileWarAndPeace = fileWarAndPeace.replace("\uFEFF", "");


        String[] words = fileWarAndPeace.split("\\s+");
        System.out.println("размер массива: " + words.length);

        Set<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println("Количество уникальных элементов в коллекции Set: " + set.size());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        System.out.println("Количество уникальных элементов в карте Map: " + map.size());

        Set<Map.Entry<String, Integer>> set1 = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set1);
        Collections.sort(list, new Comparator<>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        System.out.println("Первые 10 максимальный значений ключей:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Индекс № " + i + " -> " + list.get(i));
        }
    }

    public static String readAllBytesJava7(String file) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
