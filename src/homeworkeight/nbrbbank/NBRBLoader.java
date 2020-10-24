package homeworkeight.nbrbbank;

import homeworkeight.SiteLoader;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader {

    String rateKey = "Cur_OfficialRate";

    /**
     * Метод для запуска загрузки курса валют
     *
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/" + currencyName.getId() + "?parammode=1", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     *
     * @param content      то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        String currencyRate;
        int firstIndexRateKey = content.indexOf(rateKey);
        double rate = 0;
        try{
            currencyRate = content.substring((firstIndexRateKey + 18), (firstIndexRateKey + 24));
            rate += Double.parseDouble(currencyRate);
        } catch (NullPointerException | NumberFormatException ex){
            System.out.println("Can't read the information, the problem is: " + ex.getMessage());
        }
        return rate;
    }
}

