package homeworkfour.taskstring;

public class NumberUtils {
    private final static String[] MILLION = {"миллион", "миллиона", "миллионов"};
    private final static String[] HUNDREDS = {"тысяча", "тысячи", "тысяч"};
    private final static String[] HUNDREDS_AFTER_POINT = {"сотая", "сотые", "сотых"};
    private final static String[] WEEK = {"неделя", "недели", "недель"};
    private final static String[] HOURS = {" час ", " часа ", " часов "};
    private final static String[] MINUTES = {" минута ", " минуты ", " минут "};
    private final static String[] SECONDS = {" секунда ", " секунды ", " секунд "};
    private final static String[] MILLISECONDS = {" миллисекунда ", " миллисекунды ", " миллисекунд "};


    public String toStringInt(int number) {
        return translateNumberToWords(number);
    }

    public String toStringDouble(double number) {
        String inLetters;
        int number1 = (int) number;
        int newNumber = (int) (number * 100 % 100);
        inLetters = translateNumberToWords(number1);
        if (newNumber == 0) {
            inLetters = inLetters + " целых ноль сотых";
        }
        if (newNumber == 1 || newNumber == 2) {
            inLetters = inLetters + " целых " + getSpecificUnitWord(newNumber)
                    + getDeclension(newNumber, HUNDREDS_AFTER_POINT);
        }
        if (newNumber > 2 && newNumber < 20) {
            inLetters = inLetters + " целых " + getUnitWord(newNumber)
                    + getDeclension(newNumber, HUNDREDS_AFTER_POINT);
        }
        if (newNumber > 20 || newNumber == 20) {
            inLetters = inLetters + " целых " + translateHundredToWordExclusion(newNumber)
                    + getDeclension(newNumber, HUNDREDS_AFTER_POINT);
        }
        return inLetters;
    }

    public String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat) {
        String str = "";
        if (shortFormat == false) {
            long SSS = millisecond % 1000;
            millisecond = millisecond / 1000;
            long HH = millisecond / 60 / 60;
            long mm = millisecond / 60 - HH * 60;
            long ss = millisecond % 60;
            return HH + getDeclension((int) HH, HOURS) + mm + getDeclension((int) mm, MINUTES) + ss
                    + getDeclension((int) ss, SECONDS) + SSS + getDeclension((int) SSS, MILLISECONDS);
        }
        if (shortFormat) {
            long SSS = millisecond % 1000;
            millisecond = millisecond / 1000;
            long HH = millisecond / 60 / 60;
            long mm = millisecond / 60 - HH * 60;
            long ss = millisecond % 60;
            if (HH < 10) {
                str = str + "0" + HH + ":";
            } else {
                str = str + HH + ":";
            }
            if (mm < 10) {
                str = str + "0" + mm + ":";
            } else {
                str = str + mm + ":";
            }
            if (ss < 10) {
                str = str + "0" + ss + ".";
            } else {
                str = str + ss + ".";
            }
            if (SSS > 0 && SSS < 9) {
                str = str + "00" + SSS;
            } else if (SSS > 10 && SSS < 99) {
                str = str + "0" + SSS;
            } else if (SSS > 100) {
                str = str + SSS;
            }
            return str;
        }
        return str;
    }

    public String toWeek(int day) {
        return day / 7 + " " + getDeclension(day / 7, WEEK);
    }

    private String translateNumberToWords(int number) {
        int millions = 1000000;
        int thousands = 1000;
        String inLetters = "";
        if (number / millions != 0) {
            inLetters += translateHundredToWord((number / millions)) + " "
                    + getDeclension((number / millions), MILLION);
        }
        number = number % millions;
        if (number / thousands != 0) {
            inLetters += translateHundredToWordExclusion((number / thousands)) + " "
                    + getDeclension((number / thousands), HUNDREDS);
        }
        number = number % thousands;
        if (number != 0) {
            inLetters += translateHundredToWord(number);
        }
        return inLetters;
    }

    private String translateHundredToWord(int number) {
        String str = "";
        int tmpNumber = number;
        if (tmpNumber == 0) {
            return str;
        }
        if (tmpNumber / 100 == 0) {
            str = "";
        }
        if (tmpNumber / 100 > 0) {
            str = " " + getHundredthWord(tmpNumber / 100);
            tmpNumber = tmpNumber % 100;
        }
        if (tmpNumber > 0 && tmpNumber < 20) {
            str = str + " " + getUnitWord(tmpNumber);
            tmpNumber = 0;
        }
        if (tmpNumber >= 20) {
            str = str + " " + getDecadeWord(tmpNumber / 10);
            tmpNumber = tmpNumber % 10;
        }
        if (tmpNumber > 0) {
            str = str + " " + getUnitWord(tmpNumber);
        }
        return str;
    }

    private String translateHundredToWordExclusion(int number) {
        String str = "";
        int tmpNumber = number;
        if (tmpNumber == 0) {
            return str;
        }
        if (tmpNumber / 100 == 0) {
            str = "";
        }
        if (tmpNumber / 100 > 0) {
            str = " " + getHundredthWord(tmpNumber / 100);
            tmpNumber = tmpNumber % 100;
        }
        if (tmpNumber > 0 && tmpNumber < 20) {
            if (tmpNumber == 1 || tmpNumber == 2) {
                str = str + " " + getSpecificUnitWord(tmpNumber);
                tmpNumber = 0;
            } else {
                str = str + " " + getUnitWord(tmpNumber);
                tmpNumber = 0;
            }
        }
        if (tmpNumber >= 20) {
            str = str + " " + getDecadeWord(tmpNumber / 10);
            tmpNumber = tmpNumber % 10;
        }
        if (tmpNumber > 0) {
            if (tmpNumber == 1 || tmpNumber == 2) {
                str = str + " " + getSpecificUnitWord(tmpNumber);
            } else {
                str = str + " " + getUnitWord(tmpNumber);
            }
        }
        return str;
    }

    private String getDecadeWord(int number) {
        switch (number) {
            case 1:
                return "десять";
            case 2:
                return "двадцать";
            case 3:
                return "тридцать";
            case 4:
                return "сорок";
            case 5:
                return "пятьдесят";
            case 6:
                return "шестьдесят";
            case 7:
                return "семьдесят";
            case 8:
                return "восемьдесят";
            case 9:
                return "девяносто";
            default:
                return "не найдено";
        }
    }

    private String getHundredthWord(int number) {
        switch (number) {
            case 1:
                return "сто";
            case 2:
                return "двести";
            case 3:
                return "триста";
            case 4:
                return "четыреста";
            case 5:
                return "пятьсот";
            case 6:
                return "шестьсот";
            case 7:
                return "семьсот";
            case 8:
                return "восемьсот";
            case 9:
                return "девятьсот";
            default:
                return "не найдено";
        }
    }

    private String getUnitWord(int number) {
        switch (number) {
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
            case 4:
                return "четыре";
            case 5:
                return "пять";
            case 6:
                return "шесть";
            case 7:
                return "семь";
            case 8:
                return "восемь";
            case 9:
                return "девять";
            case 10:
                return "десять";
            case 11:
                return "одиннадцать";
            case 12:
                return "двенадцать";
            case 13:
                return "тринадцать";
            case 14:
                return "четырнадцать";
            case 15:
                return "пятнадцать";
            case 16:
                return "шестнадца";
            case 17:
                return "семнадцать";
            case 18:
                return "восемнадцать";
            case 19:
                return "девятнадцать";
            default:
                return "не найдено";
        }
    }

    private String getSpecificUnitWord(int number) {
        switch (number) {
            case 1:
                return "одна";
            case 2:
                return "две";
            default:
                return "не найдено";
        }
    }

    private String getDeclension(int number, String[] words) {
        int lastDigit = number % 10;
        int previous = number % 100 / 10;
        if (lastDigit == 1 && previous != 1) {
            return words[0];
        } else if (lastDigit > 1 && lastDigit < 5 && previous != 1) {
            return words[1];
        } else {
            return words[2];
        }
    }
}