package homeworkeight.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * реализация обработки дат, полученных из аргумента
 */

public class DateUtil {

    private static final DateTimeFormatter stringToDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final LocalDate DATE_TODAY = LocalDate.now();

    /**
     * метод анализа и обработки информации из аргумента
     *
     * @param dates получаемый массив данных из аргумента
     * @return дата
     */
    public static Set<LocalDate> getDates(String[] dates) {
        if (dates.length == 0) {
            System.out.println("The date is not provided");
            System.exit(1);
        }
        Set<LocalDate> dateSet = new TreeSet<>();
        for (String arg : dates) {
            if (Objects.nonNull(arg)) {
                String dateString = arg.trim();
                if (dateString.length() == 10) {
                    parseDateString(dateString, dateSet);
                } else if (dateString.length() > 10) {
                    if (dateString.contains("-")) {
                        String[] dateStrings = dateString.split("-");
                        if (dateStrings.length != 2) {
                            printAndExitForRange();
                        }
                        try {
                            LocalDate startDate = LocalDate.parse(dateStrings[0], stringToDateFormatter);
                            LocalDate endDate = LocalDate.parse(dateStrings[1], stringToDateFormatter);
                            endDate = endDate.plusDays(1);
                            while (startDate.isBefore(endDate)) {
                                if (startDate.compareTo(DATE_TODAY) > 0) {
                                    printAndExitFutureDate(startDate);
                                } else {
                                    dateSet.add(startDate);
                                    startDate = startDate.plusDays(1);
                                }
                            }
                        } catch (Exception ex) {
                            printAndExit();
                        }
                    } else {
                        String[] dateStrings = dateString.split(",");
                        for (String dateStr : dateStrings) {
                            parseDateString(dateStr, dateSet);
                        }
                    }
                } else {
                    printAndExit();
                }
            }
        }
        return dateSet;
    }

    /**
     * метод для печати информации об ошибке при неверном формате дат
     * и завершения работы программы
     */

    private static void printAndExit() {
        System.out.println("Incorrect date format has been provided. Should be dd.MM.yyyy");
        System.exit(1);
    }

    /**
     * метод для печати информации об ошибке при неверном формате периода дат
     * и завершения работы программы
     */
    private static void printAndExitForRange() {
        System.out.println("Incorrect date range has been provided. Should be dd.MM.yyyy-dd.MM.yyyy");
        System.exit(1);
    }

    /**
     * метод для печати информации, что указанная дата еще не наступила
     * и завершения работы.
     * @param date указанная дата из аргумента
     */
    private static void printAndExitFutureDate(LocalDate date) {
        System.out.println("The indicated date " + date + " does not exist");
        System.out.println("Please, write the date or period of dates again");
        System.exit(1);
    }

    /**
     * метод, который делает попытку распарсить строку и завершает работу если ловит ошибку.
     * дополнительно происходит проверка, что дата не из будущего периода.
     * @param dateString строка, которая должна быть распарсена.
     * @param dateSet дата из TreeSet коллекции.
     */

    private static void parseDateString(String dateString, Set<LocalDate> dateSet) {
        try {
            LocalDate date = LocalDate.parse(dateString, stringToDateFormatter);
            if (date.compareTo(DATE_TODAY) > 0) {
                printAndExitFutureDate(date);
            } else {
                dateSet.add(date);
            }
        } catch (Exception ex) {
            printAndExit();
        }
    }
}
