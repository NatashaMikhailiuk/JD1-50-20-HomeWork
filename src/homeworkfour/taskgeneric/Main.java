package homeworkfour.taskgeneric;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        DataContainer<Integer> data = new DataContainer<>();
        DataContainerComparator comparator = new DataContainerComparator();

        System.out.print(data.add(15) + " ");
        System.out.print(data.add(25) + " ");
        System.out.print(data.add(115) + " ");
        System.out.print(data.add(1) + " ");
        System.out.print(data.add(80) + " ");
        System.out.print(data.add(18) + " " + "\n");
        System.out.println("Массив: " + Arrays.toString(data.getItems()));
        System.out.println("Массив с выводом своего toString: " + data.toString());
        System.out.print("Получить элемент по индексу: " + data.get(2) + " " + "\n");
        System.out.println("Удаление элемента по номеру индекса: " + data.deleteIndex(8));
        System.out.println("Массив после удаления по индексу: " + Arrays.toString(data.getItems()));
        System.out.println("Удаление элемента по самому элементу: " + data.deleteItem(25));
        System.out.print("Массив после удаления по элементу: " + Arrays.toString(data.getItems()) + "\n");
        data.sort(comparator);
        System.out.println("Массив после сортировки: " + Arrays.toString(data.getItems()));
        System.out.println("Массив после сортировки с выводом своего toString: " + data.toString());

        DataContainer<String> data1 = new DataContainer<>();
        System.out.print(data1.add("Natasha") + " ");
        System.out.print(data1.add("Pasha") + " ");
        System.out.print(data1.add("Masha") + " ");
        System.out.print(data1.add("Anton") + " ");
        System.out.print(data1.add("Sergey") + " " + "" + "\n");
        System.out.println("Массив: " + Arrays.toString(data1.getItems()));
        System.out.println("Получить элемент по индексу: " + data1.get(0));
        System.out.println("Удаление элемента по номеру индекса: " + data1.deleteIndex(3));
        System.out.println("Массив после удаления по индексу: " + Arrays.toString(data1.getItems()));
        System.out.println("Удаление элемента по самому элементу: " + data1.deleteItem("Sergey"));
        System.out.println("Массив после удаления по элементу: " + Arrays.toString(data1.getItems()));
        System.out.println("Массив после сортировки с выводом своего toString: " + data1.toString());

        DataContainer<String> data2 = new DataContainer<>();

        System.out.print(data2.add("Natasha") + " ");
        System.out.print(data2.add("Pasha") + " ");
        System.out.print(data2.add("Masha") + " ");
        System.out.print(data2.add("Anton") + " ");
        System.out.print(data2.add("Sergey") + " " + "" + "\n");
        System.out.println("Массив: " + Arrays.toString(data2.getItems()));
        DataContainer.sort1(data2);
        System.out.println("Массив после сортировки: " + Arrays.toString(data2.getItems()));
        System.out.println("Массив после сортировки с выводом своего toString: " + data2.toString());

    }
}

