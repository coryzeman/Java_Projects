import javax.swing.*;

// Main class that serves as the entry point for the banking application GUI
public class Main {
    public static void main(String[] args) {
        // Create an instance of the SetBalance frame
        SwingUtilities.invokeLater(() -> new SetBalance(new BankingLogic()));
    }
}
