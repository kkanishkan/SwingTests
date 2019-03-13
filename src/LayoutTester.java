import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LayoutTester extends JFrame{
    private static final int frame_width = 1500;
    private static final int frame_height = 1100;

    private JPanel cart;
    private JPanel register;
    private JPanel nutrition;
    private JPanel scan;

    public LayoutTester() {
        createGroceryCartPanel();
        createNutritionScannerPanel();
        createCashRegisterPanel();
        createScanItemsPanel();

        add(scan, BorderLayout.CENTER);
        add(cart, BorderLayout.WEST);
        add(register, BorderLayout.EAST);
        add(nutrition, BorderLayout.SOUTH);
        setSize(frame_width, frame_height);
    }

    public void createScanItemsPanel() {
        scan = new JPanel();
        JButton scanButton = new JButton("SCAN GROCERY ITEM");
        scan.setLayout(new BorderLayout());
        scan.add(scanButton, BorderLayout.NORTH);
        scan.setSize(50,30);
    }

    public void createGroceryCartPanel() {
        cart = new JPanel();
        JTextArea cartField = new JTextArea(20, 40);
        cartField.setText("Grocery Cart\n");
        cartField.setEditable(false);

        JLabel cartLabel = new JLabel("Grocery Cart");
        JButton refill = new JButton("REFILL");


        Border border = BorderFactory.createLineBorder(Color.RED);
        cartField.setBorder(border);

        cart.setLayout(new BorderLayout());
        cart.add(cartField, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,2));
        titlePanel.add(cartLabel);
        titlePanel.add(refill);
        cart.add(titlePanel, BorderLayout.NORTH);

    }

    public void createCashRegisterPanel() {
        register = new JPanel();
        JTextArea registerField = new JTextArea(20,40);
        registerField.setText("Cash Register\n");
        registerField.setEditable(false);

        JLabel registerLabel = new JLabel("Cash Register");
        JButton checkoutButton = new JButton("CHECKOUT");

        Border border = BorderFactory.createLineBorder(Color.RED);
        registerField.setBorder(border);

        register.setLayout(new BorderLayout());
        register.add(registerField, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,2));
        titlePanel.add(registerLabel);
        titlePanel.add(checkoutButton);
        register.add(titlePanel, BorderLayout.NORTH);
    }

    public void createNutritionScannerPanel() {
        nutrition = new JPanel();
        JTextArea nutritionField = new JTextArea(20,80);
        nutritionField.setText("Nutrition\n");
        nutritionField.setEditable(false);

        JLabel nutriLabel = new JLabel("CART NUTRITION INFORMATION");
        JButton scan = new JButton("SCAN FOOD ITEM");
        JButton clear = new JButton("CLEAR");
        JButton cals = new JButton("Cals");
        JButton carbs = new JButton("Carbs");
        JButton fat = new JButton("Fat");
        JButton sugar = new JButton("Sugar");

        Border border = BorderFactory.createLineBorder(Color.RED);
        nutritionField.setBorder(border);

        nutrition.setLayout(new BorderLayout());
        nutrition.add(nutritionField, BorderLayout.CENTER);

        JPanel nutriInfoTop = new JPanel();
        nutriInfoTop.setLayout(new GridLayout(1,3));
        nutriInfoTop.add(nutriLabel);
        nutriInfoTop.add(scan);
        nutriInfoTop.add(clear);

        JPanel nutriInfoBottom = new JPanel();
        nutriInfoBottom.setLayout(new GridLayout(1,4));
        nutriInfoBottom.add(cals);
        nutriInfoBottom.add(carbs);
        nutriInfoBottom.add(fat);
        nutriInfoBottom.add(sugar);

        nutrition.add(nutriInfoTop, BorderLayout.NORTH);
        nutrition.add(nutriInfoBottom, BorderLayout.SOUTH);
    }
}
