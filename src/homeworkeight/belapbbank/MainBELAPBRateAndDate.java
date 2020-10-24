package homeworkeight.belapbbank;

import homeworkeight.SiteLoaderBelapb;
import homeworkeight.utils.DateUtil;
import homeworkeight.utils.ScannerHelper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

public class MainBELAPBRateAndDate {
    private static SiteLoaderBelapb loader = new BELAPBLoaderRateAndDate();

    public static void main(String[] args) {

        DateTimeFormatter dateToStringFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String fileName = "BELAPBBankCurrency.txt";
        Set<LocalDate> dates = new TreeSet<>();
        DateUtil.getDates(args, dates);
        String path = ScannerHelper.scannerHelper(fileName);

        for (LocalDate date : dates) {
            String dateStr = date.format(dateToStringFormatter);
            printRates(dateStr);
            saveToFile(path, dateStr);
        }
    }

    public static void printRates(String date) {
        System.out.println("EUR: " + loader.load(SiteLoaderBelapb.Currency.EUR, date));
        System.out.println("RUB: " + loader.load(SiteLoaderBelapb.Currency.RUB, date));
        System.out.println("USD: " + loader.load(SiteLoaderBelapb.Currency.USD, date));
    }

    private static void saveToFile(String path, String date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("Date: " + date + "\r\n");
            writer.write(SiteLoaderBelapb.Currency.USD + ": ");
            writer.write((loader.load(SiteLoaderBelapb.Currency.USD, date)) + " ");
            writer.write(SiteLoaderBelapb.Currency.EUR + ": ");
            writer.write((loader.load(SiteLoaderBelapb.Currency.EUR, date)) + " ");
            writer.write(SiteLoaderBelapb.Currency.RUB + ": ");
            writer.write((loader.load(SiteLoaderBelapb.Currency.RUB, date)) + " ");
            writer.write("\r\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
