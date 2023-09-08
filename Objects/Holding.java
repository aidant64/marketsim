package Objects;

public class Holding {
    private final String ticker;
    private int amount;

    private double price;

    public Holding(String ticker, int amount, double price){
        this.ticker = ticker;
        this.amount = amount;
        this.price = price;
    }

    public String getTicker(){
        return ticker;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public double getPrice(){
        return price;
    }
}
