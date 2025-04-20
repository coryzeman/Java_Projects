import javax.swing.*;

// Class to handle the initial balance input from the user in the banking application
public class SetBalance extends JFrame {
    private BankingLogic bankingLogic; // Reference to the BankingLogic

    // Constructor to set up the initial balance frame
    public SetBalance(BankingLogic bankingLogic) {
        this.bankingLogic = bankingLogic; // Initialize the banking logic
        setTitle("Set Initial Balance");
        setSize(300, 150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel); // Set up components

        setVisible(true); // Make the frame visible
    }

    // Method to place components on the panel
    private void placeComponents(JPanel panel) {
        panel.setLayout(null); // Use no layout manager, set positions manually

        JLabel balanceLabel = new JLabel("Enter initial balance:");
        balanceLabel.setBounds(10, 20, 150, 25);
        panel.add(balanceLabel); // Add label to the panel

        JTextField balanceField = new JTextField(20);
        balanceField.setBounds(160, 20, 100, 25);
        panel.add(balanceField); // Add text field to the panel

        JButton setBalanceButton = new JButton("Set Balance");
        setBalanceButton.setBounds(10, 60, 150, 25);
        panel.add(setBalanceButton); // Add button to the panel

        // Action Listener for setting the initial balance
        setBalanceButton.addActionListener(e -> {
            try {
                double balance = Double.parseDouble(balanceField.getText());
                bankingLogic.setBalance(balance); // Set the balance in BankingLogic
                JOptionPane.showMessageDialog(panel, "Balance set to: $" + balance);
                dispose(); // Close the initial balance frame
                new BankingApp(bankingLogic); // Open the main banking app
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please enter a valid amount.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(panel, ex.getMessage()); // Show error message
            }
        });
    }
}
