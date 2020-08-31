package homeworkone;

public class HomeWork1Task2 {
    public static void main(String[] srg) {
        int a = 5;
        int b = 2;
        int c = 8;
        int d = 7;
        boolean slip = true;
        boolean wakeUp = false;
        System.out.println("example 1 = " + (a + b / c));// решение 2/8=0+5=5
        System.out.println("example 2 = " + ((a + b) / c));// решение 5+2=7/8=0
        System.out.println("example 3 = " + ((a + b++) / c));//решение 5+2=7/8=0, b=3
        b = 2;
        System.out.println("example 4 = " + ((a + b++) / --c));//решение b++ = 3, 5+2=7, --с= 7, 7/7 =1
        b = 2;
        c = 8;
        // решение b++ = 3, 5*2=10, 10>>2=2, --c = 7, 2/7=0
        System.out.println("example 5 = " + ((a * b >> b++) / --c));
        b = 2;
        c = 8;
        /*решение 1) 5+7=12, 2) 12>20=false,
        выполняем 3) b++=3, 22*2=44, 44>>2 = 11,  4)--c = 7, 5) 11/7 = 1 */
        System.out.println("example 6 = " + ((a + d > 20 ? 68 : 22 * b >> b++) / --c));
        b = 2;
        c = 8;
        /*разные типы дают ошибку компиляции, 68>=68 - тип boolean,  22*b>>b++ - тип int */
//        System.out.println("example 7 = "+  ((a+d>20?68>=68:22*b>>b++)/--c));
        int f = 12;
        int e = 6;
        /* решение 6-2=4, 4>3 = true, 12*12 = 144,
        144<=119 = false, ответ false т.к. одно из значений равно false, чтобы получить true,
        обe части должны быть true */
        System.out.println("example 8 = " + (e - b > 3 && f * f <= 119));
        /*решение - проверяем Slip = true,
        проверяем WakeUp = false, ответ false, т.к. одно из значений равно false, чтобы получить true,
        обe части должны быть true */
        System.out.println("example 9 = " + (slip && wakeUp));
    }
}
