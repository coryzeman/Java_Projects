import java.util.Scanner;

/**
 * Main class for the Java Banking application.
 * This class is responsible for creating a CheckingAccount object,
 * prompting the user for deposits and withdrawals, and displaying
 * the account summary and details, including interest calculations.
 */
public class Main {
    public static void main(String[] args) {
        // Create a CheckingAccount object with a realistic interest rate of 0.5%
        CheckingAccount account = new CheckingAccount(0.5);

        // Set account details
        account.setFirstName("Adam");
        account.setLastName("Johnson");
        account.setAccountID(123456789);

        // Print initial account summary
        account.accountSummary();

        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get deposit amount from user
        System.out.print("\nEnter amount to deposit (positive value): $");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        System.out.println("New balance after deposit: $" + String.format("%.2f", account.getBalance()));

        // Get withdrawal amount from user
        System.out.print("\nEnter amount to withdraw (positive value): $");
        double withdrawalAmount = scanner.nextDouble();
        account.processWithdrawal(withdrawalAmount);
        System.out.println("New balance after withdrawal: $" + String.format("%.2f", account.getBalance()));

        // Display final account details
        account.displayAccount();

        // Close the scanner
        scanner.close();
    }
}
