package homeworkfour.taskgeneric;

import java.util.Arrays;
import java.util.Comparator;


public class DataContainer<T> {
    private T[] data;
    private final int DEFAULT_SIZE = 10;
    private int lastIndex = 0;


    public DataContainer() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
    }

    public int add(T item) {
        if (lastIndex > data.length - 1) {
            data = Arrays.copyOf(data, data.length * 2);/* не уверена что лучше, задействовать процессор
                                                                    или память*, решилась все же на память*/
            data[lastIndex] = item;
            lastIndex++;
            return lastIndex - 1;
        } else {
            data[lastIndex] = item;
            lastIndex++;
            return lastIndex - 1;
        }
    }

    public T get(int index) {
        return data[index];
    }

    public T[] getItems() {
        return data;
    }

    public boolean deleteIndex(int index) {
        for (int i = index; i < data.length - 1; i++) {
            if (index < data.length - 1) {
                data[i] = data[i + 1];
                continue;
            }
            return true;
        }
        if (index > data.length) {
            return false;
        }
        this.data = Arrays.copyOf(data, data.length - 1);
        return true;
    }

    public boolean deleteItem(T item) {
        for (int i = 0; i < data.length; i++) {
            T find = data[i];
            if (find != null && find.equals(item)) {
                data[i] = null;
                for (int j = i; j < data.length - 1; j++) {
                    T tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
                this.data = Arrays.copyOf(data, data.length - 1);
                return true;
            }
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < data.length; i++) {
            int maxIndex = i;
            for (int j = i; j < data.length; j++) {
                if (comparator.compare(data[maxIndex], data[j]) > 0) {
                    maxIndex = j;
                }
            }
            T t = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = t;
        }
    }

    public static <T> void sort1(DataContainer<T> dataContainer) {
        T[] containerData = dataContainer.getItems();
        for (int i = 0; i < containerData.length; i++) {
            int maxIndex = i;
            for (int j = i; j < containerData.length; j++) {
                if (containerData[j] != null && ((Comparable) containerData[maxIndex]).compareTo(containerData[j]) > 0) {
                    maxIndex = j;
                }
            }
            T t = containerData[maxIndex];
            containerData[maxIndex] = containerData[i];
            containerData[i] = t;
        }
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (i != 0) {
                    str += ", ";
                }
                str += data[i];
            } else {
                str += "";
            }
        }
        return str + "]";
    }
}


