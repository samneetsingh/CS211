/*
Samneet Singh
Computer Science 211
01/18/2020
To extend the grocery bill class and calculate the customer discount
*/

import java.util.ArrayList;

public class DiscountApp extends GroceryBill {

    // create data fields
    private boolean discount;
    private int itemsCount;
    private double total;
    private double internalDiscount;

    // create single parameter constructor
    public DiscountApp(boolean discount) {
        this.receipt = new ArrayList<Item>();
        this.itemsCount = 0;
        this.discount = discount;
        total = 0.0;
        internalDiscount = 0.0;
    }

    // create zero parameter constructor
    public DiscountApp() {
        this(false);
    }

    // create add method that takes arguments Item and int
    public boolean add(Item i, int numItemsPurchased) {

        // create counter for numbner of items
        itemsCount += numItemsPurchased;
        for (int count = 0; count < numItemsPurchased; count++) {
            receipt.add(i);
            total += i.getPrice();
            internalDiscount += i.getDiscount();
        }
        return true;
    }

    // create getTotal method which gets total price
    public double getTotal() {
        return Math.rint(total * 100) / 100.0;
    }

    // create setDiscount method which sets the amount of discount that needs to be applied
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    // create a method that removes items from the list
    public boolean remove(Item i, int numItemsRemoved) {
        itemsCount -= numItemsRemoved;
        for (int count = 0; count < numItemsRemoved; count++) {
            if (receipt.remove(i)) {
                total -= i.getPrice();
                internalDiscount -= i.getDiscount();
            } else {
                return false;
            }
        }
        return true;
    }
}
