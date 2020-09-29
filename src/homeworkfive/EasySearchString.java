package homeworkfive;


public class EasySearchString implements ISearchEngine {


    @Override
    public long search(String text, String word) {
        long counter = 0;
        text = text.trim();
        text = text.replaceAll("\\p{Punct}", "")
                .replace("\uFEFF", " ").replaceAll("\\s{2,}", " ")
                .toLowerCase();
        String searchRequest  = " " + word + " ";
        int index = 0;
        while (text.indexOf(searchRequest, index) > -1) {
            index = text.indexOf(searchRequest, index) + searchRequest.length();
            counter++;
        }
        return counter;
    }
}



