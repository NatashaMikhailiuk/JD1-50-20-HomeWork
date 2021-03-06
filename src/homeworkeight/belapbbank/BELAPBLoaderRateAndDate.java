package homeworkeight.belapbbank;

import homeworkeight.SiteLoaderBelapb;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class BELAPBLoaderRateAndDate extends SiteLoaderBelapb {


    /**
     * Метод для запуска загрузки курса валют
     *
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */


    @Override
    public double load(Currency currencyName, String date) {
        return load("https://belapb.by/ExCardsDaily.php?" + "ondate=" + date, currencyName);
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
        String find = "<RateSell>";
        try {
            int currencyRateIndex = content.indexOf(currencyName.name());
            try {
                currencyRateSubstring = content.substring(currencyRateIndex, (currencyRateIndex + 200));
            } catch (StringIndexOutOfBoundsException ex) {
            }
            currencyRateIndex = currencyRateSubstring.indexOf(find);
            try {
                currencyRateSubstring = currencyRateSubstring.substring((currencyRateIndex + 10), (currencyRateIndex + 16));
            } catch (StringIndexOutOfBoundsException ex) {
            }
            rate = Double.parseDouble(currencyRateSubstring);
        } catch (NullPointerException | NumberFormatException ex) {
            // Here should be logging to file
            System.out.println("Can't read the information, because the information is absent, check the date");
        }
        return rate;
    }
}


