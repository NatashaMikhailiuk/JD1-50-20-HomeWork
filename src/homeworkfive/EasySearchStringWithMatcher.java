package homeworkfive;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasySearchStringWithMatcher implements ISearchEngine {


    @Override
    public long search(String text, String word) {
        String textSearch = text.toLowerCase();
        String wordSearch = "[\\s\"-{1,}(\uFEFF](" + word + ")[,.?!-\"()\\s]";
        long counter = 0;
        Pattern pattern = Pattern.compile(wordSearch);
        Matcher matcher = pattern.matcher(textSearch);
        while(matcher.find()){
            counter++;
        }
        return counter;
    }
}



