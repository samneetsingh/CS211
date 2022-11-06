/*
Samneet Singh
01/13/2020
Computer Science 211
To implement that Asset interface and calculate the market value and profit of an iPhone
 */

public class IPhone implements Asset {

    // create data fields for the program
    public static final double annualDepreciation = 0.2;
    private double originalCost;
    private int currentAge;
    private double marketValue;
    private double profit;

    // Create the constructor
    public IPhone(int currentAge,double  originalCost){

        double newItemValueMultiple = (1 - annualDepreciation); // calculate the value of the item after depreciating one year

        for (int i = 0; i < currentAge; i++) { // calculate how much the item depreciates in total

            newItemValueMultiple *= newItemValueMultiple;

        }
        marketValue = newItemValueMultiple * originalCost; // calculate the market value

        profit = marketValue - originalCost; // calculate the profit
    }

    //implement the methods from the asset interface
    public double getMarketValue() {
        return marketValue;
    }

    public double getProfit() {
        return profit;
    }
}
