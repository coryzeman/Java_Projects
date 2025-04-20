import javax.swing.*;
import java.awt.event.ActionEvent;

    /*
     * BankingApp class that serves as the main frame for the banking application
     * It allows the user to deposit, withdraw, and exit the application.
    */
public class BankingApp extends JFrame {
    private BankingLogic bankingLogic; // Reference to the BankingLogic class
    private JLabel balanceLabel; // Label to display the current balance on the frame

    // Constructor to set up the banking GUI frame
    public BankingApp(BankingLogic bankingLogic) {
        this.bankingLogic = bankingLogic; // Initialize banking logic reference
        setTitle("Banking App");
        setSize(300, 225);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel); // Set up components on the panel

        setVisible(true); // Make the frame visible to the user
    }

    // Method to place components on the panel (frame)
    private void placeComponents(JPanel panel) {
        panel.setLayout(null); // Use no layout manager, set positions manually

        // Label to display current balance on the frame
        balanceLabel = new JLabel("Current Balance: $" + String.format("%.2f", bankingLogic.getBalance()));
        balanceLabel.setBounds(10, 20, 200, 25);
        panel.add(balanceLabel); // Add label to the panel

        // Create buttons for deposit, withdraw, and exit actions
        JButton depositButton = createButton(panel, "Deposit", 10, 60);
        JButton withdrawButton = createButton(panel, "Withdraw", 10, 100);
        JButton exitButton = createButton(panel, "Exit", 10, 140);

        // Action Listener for deposit button
        depositButton.addActionListener(e -> handleTransaction(true));

        // Action Listener for withdraw button
        withdrawButton.addActionListener(e -> handleTransaction(false));

        // Action Listener for exit button to close the application
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Remaining Balance: $" + String.format("%.2f", bankingLogic.getBalance()) + "\nExiting Banking Application...");
            System.exit(0); // Exit the application
        });
    }

    // Helper method to create buttons with specified text and position
    private JButton createButton(JPanel panel, String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 25);
        panel.add(button);
        return button;
    }

    // Method to handle deposit/withdraw action based on user input
    private void handleTransaction(boolean isDeposit) {
        String action = isDeposit ? "deposit" : "withdraw";
        String amountStr = JOptionPane.showInputDialog(this, "Enter amount to " + action + ":");

        try {
            double amount = Double.parseDouble(amountStr);
            if (isDeposit) {
                bankingLogic.deposit(amount); // Call deposit method from BankingLogic
            } else {
                bankingLogic.withdraw(amount); // Call withdraw method from BankingLogic
            }
            updateBalanceLabel(); // Update balance label after transaction
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage()); // Show error message
        }
    }

    // Method to update the balance label with the current balance
    private void updateBalanceLabel() {
        balanceLabel.setText("Current Balance: $" + String.format("%.2f", bankingLogic.getBalance()));
    }
}
