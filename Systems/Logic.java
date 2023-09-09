package Systems;

import Objects.Holding;
import Utils.HoldingsUtil;
import Utils.NetworkUtil;
import Utils.ParseUtil;
import Utils.StorageUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Logic {

    private List<Holding> holdings;
    private double cash;

    public Logic() {

        holdings = new ArrayList<>();
    }

    public String[] searchEntered(String searchText) {
        if (searchText == null || searchText.length() == 0)
            return null;
        String data = NetworkUtil.queryTickerWebData(searchText);
        return (!ParseUtil.isValidStock(data)) ? null : ParseUtil.parseData(searchText, data);
    }

    public boolean buttonPressed_reset(JFrame frame) {
        final String confirmMessage = "Are you sure you want to reset the simulator?\n(You will restart with " +
                "no stocks and 1000 USD)";
        int result = JOptionPane.showConfirmDialog(frame, confirmMessage, "", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.NO_OPTION || result == -1)
            return false;
        if (holdings.isEmpty() && cash == StorageUtil.STARTING_CASH)
            return false;

        StorageUtil.overwriteFileLines(new String[] { String.valueOf(StorageUtil.STARTING_CASH) });
        return true;
    }

    public String checkIfTransactionPossible(boolean isBuy, String ticker, String quant, String cPrice) {
        int shares;
        try {
            shares = Integer.parseInt(quant);
            if (shares <= 0) {
                if (isBuy) {
                    return "Status: Buy Failed! Number of shares must be positive whole number";
                }
                return "Status: Sell Failed! Number of shares must be positive whole number";
            }

            double transactionCost = Float.parseFloat(cPrice) * shares;

            if (isBuy) {
                // buy
                if (transactionCost > cash) {
                    return "Status: Buy failed! Not enough cash";
                }
            } else {
                int numberSharesOwned = 0;
                for (Holding holding : holdings) {
                    if (holding.getTicker().toLowerCase().equals(ticker.toLowerCase())) {
                        numberSharesOwned = holding.getAmount();
                    }
                }
                if (shares > numberSharesOwned) {
                    return "Status: Sell Failed! Only " + numberSharesOwned + " shares of " + ticker.toUpperCase()
                            + " owned";
                }
            }

        } catch (Exception e) {
            if (isBuy)
                return "Status: Buy Failed! Number of shares must be an integer";
            return "Status: Sell Failed! Number of shares must be an integer";
        }

        return "1";
    }

    public String buyProcess(String ticker, int quant, double price) {
        double transactionCost = price * quant;
        cash -= transactionCost;
        HoldingsUtil.buy(ticker, quant, price, holdings);
        StorageUtil.overwriteFileLines(getHoldingsForWriting());
        return "Status: Buy Executed! " + quant + " shares of " + ticker;
    }

    public String sellProcess(String ticker, int quant, double price) {
        cash += price * quant;
        HoldingsUtil.sell(ticker, quant, price, holdings);
        StorageUtil.overwriteFileLines(getHoldingsForWriting());
        return "Status: Sell Executed! " + quant + " shares of " + ticker;
    }

    private String[] getHoldingsForWriting() {
        String[] res = new String[holdings.size() + 1];
        res[0] = String.valueOf(cash);
        for (int i = 0; i < holdings.size(); i++) {
            res[i + 1] = holdings.get(i).getTicker() + " " + holdings.get(i).getAmount();
        }
        return res;
    }

    private String[] holdingsToStrArr() {
        String[] res = new String[holdings.size()];
        int i = 0;
        for (Holding holding : holdings) {
            res[i] = holding.getTicker() + " " + holding.getAmount();
            i++;
        }
        return res;
    }

    public Holding[] getHoldingsForDisplayPurpose() {
        return holdings.toArray(new Holding[0]);
    }

    public List<Holding> getHoldings() {
        return holdings;
    }

    public double getCash() {
        return cash;
    }

    public double generate_holdings_netWorth_cash() {

        holdings.clear();

        if (!StorageUtil.doesFileExist())
            StorageUtil.overwriteFileLines(new String[] { String.valueOf(StorageUtil.STARTING_CASH) });

        List<String> fileContents = StorageUtil.readFileLines();

        double netWorth = cash = Double.parseDouble(fileContents.remove(0));
        for (String holding : fileContents) {
            String[] lineData = holding.split(" ");
            if (lineData.length != 2)
                continue;

            // get current price
            double curPrice = ParseUtil.parseCurrentPrice(NetworkUtil.queryTickerWebData(lineData[0].toUpperCase()));
            int shares = Integer.parseInt(lineData[1]);
            double value = curPrice * shares;
            netWorth += value;

            holdings.add(new Holding(lineData[0], shares, curPrice));
        }

        return netWorth;
    }

}
