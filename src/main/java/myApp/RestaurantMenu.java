package myApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantMenu extends JPanel {
    private JLabel restaurantNameLabel;
    private JLabel statusLabel;
    private JTable menuTable;
    private DefaultTableModel tableModel;
    private JTextField totalCostField;
    private double totalCost;

    public RestaurantMenu() {
        setLayout(new BorderLayout());

        // First Row: Restaurant Name and Status
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        restaurantNameLabel = new JLabel("Restaurant Name");
        statusLabel = new JLabel("Status: Open");
        topPanel.add(restaurantNameLabel);
        topPanel.add(statusLabel);

        // Second Row: Menu Table
        String[] columnNames = {"ADD", "ITEM", "PRICE"};
        tableModel = new DefaultTableModel(columnNames, 0);
        menuTable = new JTable(tableModel);
        menuTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane tableScrollPane = new JScrollPane(menuTable);

        // Last Row: Total Cost
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        totalCostField = new JTextField("Your order will cost 0");
        totalCostField.setEditable(false);
        bottomPanel.add(totalCostField);

        // Add components to the main panel
        add(topPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener for checkbox changes
        menuTable.getModel().addTableModelListener(e -> calculateTotalCost());

        // Set initial total cost to 0
        totalCost = 0.0;
    }

    private void calculateTotalCost() {
        totalCost = 0.0;
        for (int row = 0; row < menuTable.getRowCount(); row++) {
            boolean isChecked = (boolean) menuTable.getValueAt(row, 0);
            if (isChecked) {
                double itemPrice = (double) menuTable.getValueAt(row, 2);
                totalCost += itemPrice;
            }
        }
        totalCostField.setText("Your order will cost " + totalCost);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Restaurant Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(new RestaurantMenu());
            frame.setVisible(true);
        });
    }
}
