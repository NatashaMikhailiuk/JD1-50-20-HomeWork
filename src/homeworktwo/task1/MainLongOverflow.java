package homeworktwo.task1;


public class MainLongOverflow {
    public static void main(String[] args) {
        long a = 1L;
        int b = 3;
        long maxValueLong = Long.MAX_VALUE;
        System.out.println("Long.MAX_VALUE -> " + maxValueLong);
        while (a <= maxValueLong / 3) {
            a *= b;
        }
        System.out.println("long before overflow -> " + a);
        System.out.println("long after overflow -> " + ((double) a * 3));
    }
}

