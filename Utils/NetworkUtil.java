package Utils;

import Objects.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class NetworkUtil {

    private static final String API_KEY = "ce0a5niad3i6dc1cfff0ce0a5niad3i6dc1cfffg";

    public static String queryTickerWebData(String ticker){
        try{
            return queryWebsite(generateQueryAddress(ticker));
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String generateQueryAddress(String ticker){
        String baseAddress = "https://finnhub.io/api/v1/quote?symbol=";
        return baseAddress + ticker + "&token=" + API_KEY;
    }

    private static String queryWebsite(String webAddress) throws Exception {
        URL url = new URL(webAddress);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder query = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            query.append(inputLine).append("\n");
        }

        in.close();
        return query.toString();
    }

    public static String queryTickerCandles(String ticker){
        ticker = ticker.toUpperCase();
        final String baseAddress = "https://finnhub.io/api/v1/stock/candle?symbol=";

        ZonedDateTime twoWeeksAgo = ZonedDateTime.now(ZoneOffset.UTC).minusWeeks(24);
        long start = twoWeeksAgo.toEpochSecond();

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        long end = now.toEpochSecond();

        final String url = baseAddress + ticker + "&resolution=D&from="+start+"&to="+end+"&token="+API_KEY;

        try{
            return queryWebsite(url);
        }catch (Exception e){
            return "-1";
        }

    }

    public static ArrayList<Pair> getCandles(String searchText){
        searchText = searchText.toUpperCase();

        String data = NetworkUtil.queryTickerCandles(searchText);
        List<Double> candles = ParseUtil.parseCandlesWebData(data);

        ArrayList<Pair> points = new ArrayList<>();
        for(int i = 0; i < candles.size(); i++){
            points.add(new Pair(i, candles.get(i).floatValue()));
        }

        return points;
    }


}
