/**
 * BankAccount class serves as a superclass for creating bank account objects.
 * It holds the basic attributes and methods common to all bank accounts,
 * including first name, last name, account ID, and balance.
 * It provides functionalities for depositing and withdrawing funds,
 * as well as retrieving account information and generating an account summary.
 */
public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor: Initializes the balance to zero
    public BankAccount() {
        this.balance = 0.0;
    }

    // Deposit method: Adds the specified amount to the balance
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Withdrawal method: Subtracts the specified amount from the balance
    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    // Getter & Setters for firstName, lastName, and accountID
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    //Getter to return balance
    public double getBalance() {
        return this.balance;
    }

    // Method to print the account information
    public void accountSummary() {
        System.out.println("\nAccount Summary:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Account ID: " + getAccountID());
        System.out.println("Available Balance: $" + String.format("%.2f", getBalance()));
    }
}