package homeworksix.service.sorter;

import java.util.Comparator;
import java.util.List;

public class Sorter<T> {

    public void bubbleMethodSort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++) {
            int maxIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (comparator.compare(list.get(maxIndex), list.get(j)) > 0) {
                    maxIndex = j;
                }
            }
            T tmp = list.get(maxIndex);
            list.set(maxIndex, list.get(i));
            list.set(i, tmp);
        }
    }
}

