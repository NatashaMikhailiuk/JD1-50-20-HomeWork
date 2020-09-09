package homeworktwo.task1;

public class MainMultiplyDigitsWhile {
    public static void main(String[] args) {
        String arg = args[0];
        String[] digits = arg.split("");
        String argForPrint = String.join(" * ", digits);
        int number = Integer.parseInt(args[0]);
        int mult = 1;
        while (number > 0) {
            mult = mult * (number % 10);
            number = number / 10;
        }
        System.out.print(argForPrint + " = " + mult);
    }
}
