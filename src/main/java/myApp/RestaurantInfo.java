package myApp;

import javax.swing.*;
import java.awt.*;

public class RestaurantInfo extends JPanel {
    private JLabel nameLabel;
    private JLabel statusLabel;
    private JLabel timingLabel;
    private JLabel locationLabel;
    private JButton getMenuButton;

    public RestaurantInfo() {
        setLayout(new GridLayout(3, 2));

        nameLabel = new JLabel("Restaurant Name:");
        statusLabel = new JLabel("Status: Open");
        timingLabel = new JLabel("Timings: 9:00 AM - 10:00 PM");
        locationLabel = new JLabel("Location: 123 Main Street, City");
        getMenuButton = new JButton("Get Menu");

        // Add components to rows
        add(nameLabel);
        add(statusLabel);
        add(timingLabel);
        add(locationLabel);
        add(new JLabel()); // Empty label for spacing
        add(getMenuButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Restaurant Information");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.add(new RestaurantInfo());
            frame.setVisible(true);
        });
    }
}
