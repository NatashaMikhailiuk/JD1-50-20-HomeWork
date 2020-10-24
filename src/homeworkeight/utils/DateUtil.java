package homeworkeight.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;

public class DateUtil {


    private static final DateTimeFormatter stringToDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public static Set<LocalDate> getDates(String[] args, Set<LocalDate> dates) {
        if (args.length == 0) {
            System.out.println("The date is not provided");
            System.exit(1);
        }
        for (String arg : args) {
            if (Objects.nonNull(arg)) {
                String dateString = arg.trim();
                if (dateString.length() == 10) {
                    try {
                        LocalDate date = LocalDate.parse(dateString, stringToDateFormatter);
                        dates.add(date);
                    } catch (Exception ex) {
                        System.out.println("Incorrect date format has been provided. Should be dd.MM.yyyy");
                        System.exit(1);
                    }
                } else if (dateString.length() > 10) {
                    if (dateString.contains("-")) {
                        String[] dateStrings = dateString.split("-");
                        if (dateStrings.length != 2) {
                            System.out.println("Incorrect date range has been provided. Should be dd.MM.yyyy-dd.MM.yyyy");
                            System.exit(1);
                        }
                        try {
                            LocalDate startDate = LocalDate.parse(dateStrings[0], stringToDateFormatter);
                            LocalDate endDate = LocalDate.parse(dateStrings[1], stringToDateFormatter);
                            endDate = endDate.plusDays(1);
                            while (startDate.isBefore(endDate)) {
                                dates.add(startDate);
                                startDate = startDate.plusDays(1);
                            }
                        } catch (Exception ex) {
                            System.out.println("Incorrect date format has been provided. Should be dd.MM.yyyy");
                            System.exit(1);
                        }
                    } else {
                        String[] dateStrings = dateString.split(",");
                        for (String dateStr : dateStrings) {
                            try {
                                LocalDate date = LocalDate.parse(dateStr, stringToDateFormatter);
                                dates.add(date);
                            } catch (Exception ex) {
                                System.out.println("Incorrect date format has been provided. Should be dd.MM.yyyy");
                                System.exit(1);
                            }
                        }
                    }
                } else {
                    System.out.println("Incorrect date format has been provided. Should be dd.MM.yyyy");
                    System.exit(1);
                }
            }
        }
        return dates;
    }
}
