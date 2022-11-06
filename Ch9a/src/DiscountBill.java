/*
Samneet Singh
Computer Science 211
01/06/2020
To extend the grocery bill class in order to account for preferred customer discounts
*/
public class DiscountBill extends GroceryBill {

    // Writing fields
    private int discountItem;
    private double discount;
    private boolean preferred;

    // Write discount bill which takes an Employee and a boolean
    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
        discountItem = 0;
        discount = 0.0;
    }

    // create add which takes a parameter i which calculates discount
    public void add(Item i) {
        super.add(i);
        if (preferred && i.getDiscount() > 0) {
            discountItem++;
            discount += i.getDiscount();
        }
    }

    // write getTotal which calculates the final price after discount
    public double getTotal() {
        return (super.getTotal() - discount);
    }

    // create getter method that returns discountItem
    public int getDiscountCount() {
        return discountItem;
    }

    // create getter method that returns discount
    public double getDiscountAmount() {
        return discount;
    }

    // create getter method that calculates the percent discount
    public double getDiscountPercent() {
        return 100 * (discount / super.getTotal());
    }
}