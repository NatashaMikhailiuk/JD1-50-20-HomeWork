package homeworktwo.task1;


public class MainMultiplicationChartV1 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            for (int j = 2; j < 6; j++) {
                String space1 = " ";
                String space2 = "  ";
                if (i * j < 10) {
                    space1 = "  ";
                }
                if (i == 10) {
                    space1 = "";
                }
                System.out.print(j + " x " + i + space2 + " = " + space1 + (i * j));
                System.out.print(" ||  ");
            }
            System.out.println("");
        }
        System.out.println("======================================================================");
        for (int i = 1; i < 11; i++) {
            for (int j = 6; j < 10; j++) {
                String space3 = " ";
                String space4 = "  ";
                if (i * j < 10) {
                    space3 = "  ";
                }
                if (i == 10) {
                    space4 = " ";
                }
                System.out.print(j + " x " + i + space4 + " = " + space3 + (i * j));
                System.out.print(" ||  ");
            }
            System.out.println("");
        }
    }
}


