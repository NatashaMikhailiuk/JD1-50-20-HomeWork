package homeworkone;

public class HomeWork1Task4version2 {
    public static void main(String[] args) {
        boolean weekday = true;
        boolean vacation = false;
        boolean answer = slipIn(weekday, vacation);
        if (answer) {
            System.out.println("Можно спать дальше");
        } else {
            System.out.println("Пора идти на работу");
        }
    }

    static boolean slipIn(boolean weekday, boolean vacation) {
        return vacation || !weekday;
    }
}
