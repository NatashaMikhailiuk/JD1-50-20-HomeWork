package homeworksix.service.iterator;

import homeworkfour.taskstring.NumberUtils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator<T> {
    private final NumberUtils timeFormat = new NumberUtils();

    public void iteratorWithFor(Collection<T> list) {
        long startTimeOperation = System.currentTimeMillis();
        Object[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
        }
        long finishTimeOperation = System.currentTimeMillis();
        System.out.println("Operation \"iterationWithFor\" takes -    "
                + timeFormat.toHoursMinuteSecondMillisecond((finishTimeOperation - startTimeOperation), true)
                + " milliseconds");
    }

    public void iterator(Collection<T> list) {
        long startTimeOperation = System.currentTimeMillis();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long finishTimeOperation = System.currentTimeMillis();
        System.out.println("Operation \"iterator\" takes -            "
                + timeFormat.toHoursMinuteSecondMillisecond((finishTimeOperation - startTimeOperation), true)
                + " milliseconds");
    }
}
