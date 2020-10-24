package homeworkeight.nbrbbank;

import homeworkeight.SiteLoader;
import homeworkeight.utils.ScannerHelper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainNBRB {
    public static void main(String[] args) {
        String fileName = "NBRBBankCurrency.txt";
        String path = ScannerHelper.scannerHelper(fileName);
        printRates(new NBRBLoader());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writeRatesToFile(writer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void printRates(SiteLoader loader) {
        System.out.println("EUR: " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("RUB: " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("USD: " + loader.load(SiteLoader.Currency.USD));
    }

    private static void writeRatesToFile(BufferedWriter writer) throws IOException {
        writer.write(SiteLoader.Currency.USD + ": ");
        writer.write((new NBRBLoader().load(SiteLoader.Currency.USD)) + " ");
        writer.write(SiteLoader.Currency.EUR + ": ");
        writer.write((new NBRBLoader().load(SiteLoader.Currency.EUR)) + " ");
        writer.write(SiteLoader.Currency.RUB + ": ");
        writer.write((new NBRBLoader().load(SiteLoader.Currency.RUB)) + " ");
    }

    private static void printException(String wrongInput) {
        System.out.println("The input " + "\"" + wrongInput + "\"" + " is incorrect, try again....");
    }
}
