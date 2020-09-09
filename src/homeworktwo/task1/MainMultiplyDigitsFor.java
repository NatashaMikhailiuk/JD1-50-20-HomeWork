package homeworktwo.task1;

public class MainMultiplyDigitsFor {
    public static void main(String[] args) {
        String arg = args[0];
        String[] digits = arg.split("");
        String argForPrint = String.join(" * ", digits);
        int argument = Integer.parseInt(args[0]);
        int mult = 1;
        for (; argument > 0; argument = argument / 10) {
            mult = mult * (argument % 10);
        }
        System.out.print(argForPrint + " = " + mult);
    }
}
