package homeworkfive;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasySearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        long count = 0;
        text = text.trim();
        text = text.replaceAll("\\p{Punct}", "")
                .replace("\uFEFF"," ");
        text = text.toLowerCase();
        String[] words = text.split("\\s+");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        while (list.indexOf(word) > -1) {
            list.set(list.indexOf(word), "");
            count++;
        }
        return count;
    }
}



