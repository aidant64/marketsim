package Utils;

import java.util.ArrayList;
import java.util.List;

public class ParseUtil {

    public static boolean isValidStock(String data) {
        if (data == null)
            return false;
        if (data.length() == 0 || data.charAt(0) != '{')
            return false;
        int i = 0;
        while (data.charAt(i) != 'd') {
            i++;
            if (i >= data.length())
                return false;
        }
        if (i + 3 >= data.length())
            return false;
        return data.charAt(i + 3) != 'n';
    }

    public static String[] parseData(String ticker, String data) {
        String price = String.valueOf(parseCurrentPrice(data));
        return new String[] { ticker, price };
    }

    public static double parseCurrentPrice(String data) {
        if (data == null)
            return -1;
        StringBuilder curPrice = new StringBuilder();
        int i = 5;
        while (Character.isDigit(data.charAt(i)) || data.charAt(i) == '.') {
            curPrice.append(data.charAt(i));
            i++;
        }
        return Double.parseDouble(curPrice.toString());
    }

    public static List<Double> parseCandlesWebData(String data) {
        if (data == null || data.length() <= 2)
            return null;
        List<Double> points = new ArrayList<>();

        int i = 0;
        while (data.charAt(i) != '[') {
            i++;
        }
        i++;

        String curWord = "";
        while (data.charAt(i) != ']') {
            Character c = data.charAt(i);
            if (c == ',') {
                points.add(Double.parseDouble(curWord));
                curWord = "";
                i++;
                continue;
            }

            curWord = curWord + c;
            i++;
        }

        return points;
    }

}
