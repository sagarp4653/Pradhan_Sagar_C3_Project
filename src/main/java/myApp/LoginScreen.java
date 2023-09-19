package myApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        // Set up the JFrame
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create components
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(loginButton);

        // Add an ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Perform login validation here (e.g., check username and password)
                if (isValidLogin(username, password)) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Login successful!");
                    // You can open a new window or perform other actions upon successful login
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Invalid login credentials. Try again.");
                }

                // Clear the password field
                passwordField.setText("");
            }
        });

        // Add the panel to the JFrame
        add(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    // Simulate login validation (replace with your actual login logic)
    private boolean isValidLogin(String username, String password) {
        // Replace with your authentication logic (e.g., check against a database)
        return "admin".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginScreen();
        });
    }
}
