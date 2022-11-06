/**
 * @author Reges and Stepp, Building Java Programs
 * modified by W.P. Iverson, Bellevue College,
 * January 2021 for CS211 class
 */

// Stuart Reges
// 3/28/07
//
// Class ShoppingFrame provides the user interface for a simple shopping
// program, starting with Building Java Programs, chapter 10, project 1.
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ShoppingApp extends JFrame {

    final JCheckBox cb = new JCheckBox("(apply discounts)");
    // data FIELDS
    private final DiscountApp selections;    // assigned
    private final JTextField total;            // standard Oracle JAVA GUI

    public ShoppingApp(ArrayList<Item> products) {
        // create frame and order list
        setTitle("BJP Chapter 9 DiscountBill");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        selections = new DiscountApp();

        // Just making sure we're using the Iverson version:
        if (!(selections instanceof GroceryBill))
            throw new RuntimeException("This quarter I require GroceryBill");

        // set up text field with order total
        total = new JTextField("$0.00", 12);
        total.setEditable(false);
        total.setEnabled(false);
        total.setDisabledTextColor(Color.BLACK);
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        JLabel l = new JLabel("Order Total");
        l.setForeground(Color.YELLOW);
        p.add(l);
        p.add(total);
        add(p, BorderLayout.NORTH);

        p = new JPanel(new GridLayout(products.size(), 1));
        removeDuplicates(products);

        for (Item i : products) {
            addItem(i, p); // add selections to panel
        }
        add(p, BorderLayout.CENTER); // add panel to frame

        p = new JPanel();
        add(makeCheckBoxPanel(), BorderLayout.SOUTH);

        // adjust size to just fit
        pack();
    }

    // Below used to be separate ShoppingMain, now an easier entry point:
    public static void main(String[] args) {
        // the Catalog is a simple Array List of Items:
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item("candy bar", 1.35, 0.25));
        list.add(new Item("newspaper", 0.99, 0));
        list.add(new Item("toy car", 3.25, 0.5));
        list.add(new Item("apple", 0.3, .05));
        list.add(new Item("orange", 0.3, .05));
        list.add(new Item("notebook", 3.0, .15));
        list.add(new Item("bread", 2.25, .35));
        list.add(new Item("gift card", 75, 0));
        list.add(new Item("bagels", 1.3, .16));
        list.add(new Item("coffee", 4.25, .25));
        list.add(new Item("vinegar", 4.18, 0));
        list.add(new Item("soup", 2.5, .15));
        list.add(new Item("flour", 6.5, 2.25));
        list.add(new Item("format for all is name, price (-discount)", 0, 0));

        ShoppingApp f = new ShoppingApp(list);
        f.setVisible(true);
    }

    // Should probably use Set rather than Array List, but this is Chapter 10
    private void removeDuplicates(ArrayList<Item> products) {
        for (Item i : products) {
            if (products.indexOf(i) != products.lastIndexOf(i))
                products.remove(i);
        }
    }

    // Sets up the "discount" checkbox for the frame
    private JPanel makeCheckBoxPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        p.add(cb);
        cb.addActionListener(new EventExample());
        return p;
    }

    // adds a product to the panel, including a textfield for user input of
    private void addItem(final Item product, JPanel p) {
        JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sub.setBackground(new Color(0, 180, 0));
        final JTextField quantity = new JTextField(3);
        quantity.setHorizontalAlignment(SwingConstants.CENTER);

        // Below is a trick to make an anonymous object from an anonymous class
        // The addActionListener needs something that implements ActionListener
        // So we make an object from a class that does not exist as follows:
        quantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateItem(product, quantity);
                quantity.transferFocus();
            }
        });

        // same trick
        quantity.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                updateItem(product, quantity);
            }
        });

        sub.add(quantity);
        JLabel l = new JLabel("" + product);
        l.setForeground(Color.white);
        sub.add(l);
        p.add(sub);
    }

    // When the user types a new value into one of the quantity fields,
    // parse the input and update the ShoppingCart.  Display an error
    // message if text is not a number or is negative.
    private void updateItem(Item product, JTextField quantity) {
        int number;
        String text = quantity.getText().trim();
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException error) {
            number = 0;
        }
        if (number <= 0 && text.length() > 0) {
            Toolkit.getDefaultToolkit().beep();
            quantity.setText("");
            number = 0;
        }
        selections.add(product, number);
        updateTotal();
    }

    // reset the text field for order total
    private void updateTotal() {
        double amount = selections.getTotal();
        total.setText(NumberFormat.getCurrencyInstance().format(amount));
    }

    // This INNER CLASS is just to make some anonymous objects
    // done this way because nothing outside this class needs it
    private class EventExample implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selections.setDiscount(cb.isSelected());
            updateTotal();
        }
    }

}