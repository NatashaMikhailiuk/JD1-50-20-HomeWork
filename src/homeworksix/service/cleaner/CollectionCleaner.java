package homeworksix.service.cleaner;

import homeworkfour.taskstring.NumberUtils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionCleaner<T> {
    private final NumberUtils timeFormat = new NumberUtils();

    public void removeAll(Collection<T> list) {
        long startTimeOperation = System.currentTimeMillis();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        long finishTimeOperation = System.currentTimeMillis();
        System.out.println("Operation \"removeAll\" done and takes:   "
                + timeFormat.toHoursMinuteSecondMillisecond((finishTimeOperation - startTimeOperation), true)
                + " milliseconds");
    }
}
