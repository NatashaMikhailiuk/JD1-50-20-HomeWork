package homeworkone;

public class HomeWork1Task6 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String number = createPhoneNumber(numbers);
        System.out.println(number);
    }

    static String createPhoneNumber(int[] numbers) {
        String number = "Phone number is: ";
        number = number + "(";
        for (int i = 0; i < numbers.length; i++) {
            number = number + numbers[i];
            if (i == 2) {
                number = number + ")";
            }
            if (i == 5) {
                number = number + "-";
            }
        }
        return number;
    }
}
