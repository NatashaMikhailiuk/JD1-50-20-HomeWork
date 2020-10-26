package homeworkeight.belapbbank;

import homeworkeight.SiteLoader;
import homeworkeight.utils.ScannerHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MainBELAPBRate {
    public static final String FILE_NAME = "BELAPBBankCurrency.txt";
    private static SiteLoader loader = new BELAPBLoaderRate();

    public static void main(String[] args) {

        String path = ScannerHelper.scannerHelper(FILE_NAME);
        writeRatesToFile(path);
    }


    private static void writeRatesToFile(String path) {
        LocalDate localDate = LocalDate.now();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Date: " + localDate + "\r\n");
            double rateUSD = loader.load(SiteLoader.Currency.USD);
            writer.write("USD: " + rateUSD + " ");
            double rateEUR = loader.load(SiteLoader.Currency.EUR);
            writer.write("EUR: " + rateEUR + " ");
            double rateRUB = loader.load(SiteLoader.Currency.RUB);
            writer.write("RUB: " + rateRUB + " ");
            System.out.println("USD: " + rateUSD);
            System.out.println("EUR: " + rateEUR);
            System.out.println("RUB: " + rateRUB);
            writer.write("\r\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

