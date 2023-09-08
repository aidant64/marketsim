package Utils;

import Objects.Holding;

import java.util.ArrayList;
import java.util.List;

public class HoldingsUtil {

    //returns if already in assets
    public static boolean buy(String ticker, int quant, double price, List<Holding> holdings){
        for(Holding h : holdings){
            if(h.getTicker().equals(ticker)){
                int newAmount = h.getAmount() + quant;
                if(newAmount == 0){
                    holdings.remove(h);
                }else {
                    h.setAmount(h.getAmount() + quant);
                }
                return true;
            }
        }
        holdings.add(new Holding(ticker, quant, price));
        return false;
    }

    public static boolean sell(String ticker, int quant, double price, List<Holding> holdings){
        for(Holding h : holdings){
            if(h.getTicker().equals(ticker)){
                int newAmount = h.getAmount() - quant;
                if(newAmount == 0){
                    holdings.remove(h);
                }else {
                    h.setAmount(h.getAmount() - quant);
                }
                return true;
            }
        }
        holdings.add(new Holding(ticker, -quant, price));
        return false;
    }


}
