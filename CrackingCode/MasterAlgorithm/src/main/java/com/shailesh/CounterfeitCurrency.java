package com.shailesh;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class CounterfeitCurrency {

}

class CounterfeitCurrencyResult {
    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int countCounterfiet(List<String> serialNumber) {
        // Write your code here
        return serialNumber
                .stream()
                .filter(currency -> isLengthInRange(currency))
                .filter(currency -> isUpperCase(currency))
                .filter(currency -> isDistinct(currency))
                .filter(currency -> isYearInRange(currency))
                .map(currency -> currency.substring(7))
                .filter(currency -> hasValidEnd(currency))
                .map(currency -> extractNumber(currency))
                .filter(currency -> isValidCurrency(currency))
                .reduce(0, Integer::sum);
    }

    public static int countCounterfietWithRegex(List<String> serialNumber) {
        // Write your code here
        return serialNumber
                .stream()
                .filter(currency -> isLengthInRange(currency))
                .filter(currency -> matchPatter(currency))
                .filter(currency -> isDistinct(currency))
                .filter(currency -> isYearInRange(currency))
                .map(currency -> extractNumberAnother(currency))
                .reduce(0, Integer::sum);
    }

    private static boolean matchPatter(String currency) {
        Pattern pattern = Pattern.compile("(?:([A-Z])(?![A-Z]*?\\1)[A-Z]*)[0-9][0-9][0-9][0-9](10|20|50|100|500|1000)[A-Z]{1}");
        Matcher matcher = pattern.matcher(currency);
        return matcher.matches();
    }

    private static boolean isValidCurrency(Integer currency) {
        List<Integer> currencys = Arrays.asList(10, 20, 50, 100, 200, 500, 1000);
        return currencys.contains(currency);
    }

    private static int extractNumber(String currency) {
        int length = currency.length();
        String amount = currency.substring(0, length - 1);
        try {
            return Integer.parseInt(amount);
        } catch (Exception exception) {
            return 0;
        }
    }

    private static int extractNumberAnother(String currency) {
        int length = currency.length();
        String amount = currency.substring(7, length - 1);
        try {
            return Integer.parseInt(amount);
        } catch (Exception exception) {
            return 0;
        }
    }

    private static boolean hasValidEnd(String currency) {
        int length = currency.length();
        char lastChar = currency.charAt(length - 1);
        boolean isUpperCase = Character.isUpperCase(lastChar);
        return isUpperCase;
    }

    public static boolean isYearInRange(String currency) {
        String year = currency.substring(3, 7);
        try {
            int intYear = Integer.parseInt(year);
            if (intYear < 1900 || intYear > 2019) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }

        return true;
    }

    public static boolean isDistinct(String currency) {
        String substring = currency.substring(0, 3);
        String actual = substring
                .chars()
                .mapToObj(e -> Character.toString((char) e))
                .distinct()
                .collect(joining(""));

        return substring.equals(actual);
    }

    private static boolean isUpperCase(String currency) {
        String substring = currency.substring(0, 2);
        String uppercase = substring.toUpperCase();

        return substring.equals(uppercase);
    }

    private static boolean isLengthInRange(String currency) {
        int length = currency.length();
        if (length < 10 || length > 12) {
            return false;
        }
        return true;
    }
}
