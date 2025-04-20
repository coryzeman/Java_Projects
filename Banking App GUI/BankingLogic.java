// This class contains methods to deposit, withdraw, and get the balance of a bank account.
public class BankingLogic {
    private double balance; // Variable to hold the current balance of the account (in dollars)

    // Method to deposit money into the account (amount must be positive)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Increase balance by the deposit amount if it is positive
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            throw new IllegalStateException("Insufficient funds.");
        } else {
            balance -= amount; // Decrease balance by the withdrawal amount if sufficient funds are available
        }
    }

    // Method to get the current balance of the account (in dollars)
    public double getBalance() {
        return balance;
    }

    // Method to set the initial balance of the account (must be positive)
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance must be positive.");
        }
        this.balance = balance;
    }
}
