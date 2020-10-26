package homeworkeight.nbrbbank;

import homeworkeight.SiteLoader;
import homeworkeight.utils.ScannerHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MainNBRB {
    private static final String FILE_NAME = "NBRBBankCurrency.txt";
    private static SiteLoader loader = new NBRBLoader();

    public static void main(String[] args) {

        String path = ScannerHelper.scannerHelper(FILE_NAME);
        writeRatesToFileAndPrint(path);

    }

    private static void writeRatesToFileAndPrint(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            LocalDate localDate = LocalDate.now();
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
