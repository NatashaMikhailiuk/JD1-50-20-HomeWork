package homeworktwo.task1;


public class MainMultiplicationChartV2 {
    public static void main(String[] args) {
        String firstPartOfTable = "";
        String secondPartOfTable = "";
        for (int i = 1; i < 11; i++) {
            for (int j = 2; j < 10; j++) {
                if (j < 6) {
                    firstPartOfTable += j + " x " + i + "  = " + (i * j) + "|";
                    if (j == 5) {
                        firstPartOfTable += "\n";
                    }
                }
                if (j > 5) {
                    secondPartOfTable += j + " x " + i + " =  " + (i * j) + "|";
                    if (j == 9) {
                        secondPartOfTable += "\n";
                    }
                }
            }
        }
        System.out.println(firstPartOfTable);
        System.out.println("====================================================");
        System.out.println(secondPartOfTable);
    }
}


