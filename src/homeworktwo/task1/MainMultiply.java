package homeworktwo.task1;

public class MainMultiply {
    public static void main(String[] args) {
        int argument = Integer.parseInt(args[0]);
        int result = 1;
        for (int i = 1; i <= argument; i++) {
            result = result * i;
            System.out.print(i);
            if (i != argument) {
                System.out.print(" * ");
            }
        }
        System.out.print(" = " + result);
    }
}
