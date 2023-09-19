package myApp;

import javax.swing.*;
import java.awt.*;

public class SearchRestaurant extends JPanel {
    private JLabel titleLabel;
    private JTextField searchField;
    private JButton searchButton;

    public SearchRestaurant() {
        setLayout(new GridLayout(3, 1));

        titleLabel = new JLabel("Search for restaurant");
        searchField = new JTextField();
        searchButton = new JButton("Search");

        // Set the background color to red for the entire component
        setBackground(Color.RED);

        // Customize font and foreground color
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);

        // Add components to rows
        add(titleLabel);
        add(searchField);
        add(searchButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Search Restaurant");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.add(new SearchRestaurant());
            frame.setVisible(true);
        });
    }
}
