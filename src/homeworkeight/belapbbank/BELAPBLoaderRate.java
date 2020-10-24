package homeworkeight.belapbbank;

import homeworkeight.SiteLoader;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class BELAPBLoaderRate extends SiteLoader {


    /**
     * Метод для запуска загрузки курса валют
     *
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */


    @Override
    public double load(Currency currencyName) {
        return load("https://belapb.by/ExCardsDaily.php?" + currencyName.getId(), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     *
     * @param content      то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        double rate = 0;
        String currencyRateSubstring = "";
        try {
            int currencyRateIndex = content.indexOf(currencyName.name());
            try {
                currencyRateSubstring = content.substring(currencyRateIndex, (currencyRateIndex + 200));
            } catch (StringIndexOutOfBoundsException ex) {
            }
            currencyRateIndex = currencyRateSubstring.indexOf("<RateSell>");
            try {
                currencyRateSubstring = currencyRateSubstring.substring((currencyRateIndex + 10), (currencyRateIndex + 16));
            } catch (StringIndexOutOfBoundsException ex) {
            }
            rate = Double.parseDouble(currencyRateSubstring);
        } catch (NullPointerException | NumberFormatException ex) {
            // Here should be logging to file
            System.out.println("Can't read the information, the problem is: " + ex.getMessage());
        }
        return rate;
    }
}


