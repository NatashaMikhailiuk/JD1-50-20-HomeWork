package homeworkone;

public class HomeWork1Task4version1 {
    public static void main(String[] args) {
        boolean weekday = true;
        boolean vacation = true;
        boolean answer = slipIn(weekday, vacation);
        if (answer) {
            System.out.println("Можно спать дальше");
        } else {
            System.out.println("Пора идти на работу");
        }
    }

    static boolean slipIn(boolean weekday, boolean vacation) {
        if (weekday) {
            if (vacation) {
                return true;
            }
            return false;
        }
        return true;
    }
}
