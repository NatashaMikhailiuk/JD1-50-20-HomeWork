package homeworktwo.task4;

public class ArraySorter {


    static void bubbleMethod(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            int t = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = t;
        }
    }

    static void cocktailSortMethod(int[] array) {
        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 0; i <= array.length - 2; i++) {
                if (array[i] < array[i + 1]) {
                    int t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
            isSwapped = false;
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] < array[i + 1]) {
                    int t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                    isSwapped = true;
                }
            }
        } while (isSwapped);
    }
}
