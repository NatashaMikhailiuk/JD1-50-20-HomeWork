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

public class MainBELAPBRateAndDate {
    private static final String FILE_NAME = "BELAPBBankCurrency.txt";
    private static SiteLoaderBelapb loader = new BELAPBLoaderRateAndDate();
    private static DateTimeFormatter dateToStringFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    public static void main(String[] args) {

        Set<LocalDate> dates = DateUtil.getDates(args);
        String path = ScannerHelper.scannerHelper(FILE_NAME);
        getRate(dates, dateToStringFormatter, path);

    }

    private static void getRate(Set<LocalDate> dates, DateTimeFormatter dateToStringFormatter, String path) {
        for (LocalDate date : dates) {
            String dateForSite = date.format(dateToStringFormatter);
            saveRateToFileAndPrint(path, dateForSite);
        }
    }

    private static void saveRateToFileAndPrint(String path, String date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("Date: " + date + "\r\n");
            double rateUSD = loader.load(SiteLoaderBelapb.Currency.USD, date);
            writer.write("USD: " + rateUSD + " ");
            double rateEUR = loader.load(SiteLoaderBelapb.Currency.EUR, date);
            writer.write("EUR: " + rateEUR + " ");
            double rateRUB = loader.load(SiteLoaderBelapb.Currency.RUB, date);
            writer.write("RUB: " + rateRUB + " ");
            System.out.println("USD: " + rateUSD);
            System.out.println("EUR: " + rateEUR);
            System.out.println("RUB: " + rateRUB);
            writer.write("\r\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " The path is incorrect");
        }
    }
}
