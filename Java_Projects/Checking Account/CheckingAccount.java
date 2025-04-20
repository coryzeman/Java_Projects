/**
 * CheckingAccount class extends the BankAccount superclass to provide
 * specific functionalities for checking accounts. It includes an
 * interest rate attribute and allows for overdraft withdrawals
 * with associated fees. The class provides methods to handle
 * deposits, withdrawals, and to display account details, including
 * any fees incurred and interest earned or charged.
 */
public class CheckingAccount extends BankAccount {
    private double interestRate;
    private double fees = 0;
    private double totalDeposits = 0;
    private double totalWithdrawals = 0;

    // Constructor: Initializes the CheckingAccount with a specified interest rate
    public CheckingAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    // Deposit method: Adds the specified amount to the balance and tracks total deposits
    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            super.deposit(amount);
            totalDeposits += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // ProcessWithdrawal method: Subtracts the specified amount from the balance and tracks total withdrawals
    // Charges an overdraft fee if the balance goes negative
    public void processWithdrawal(double amount) {
        if (amount >= 0) {
            if (super.getBalance() - amount < 0) {
                super.withdrawal(amount);
                fees += 30; // Overdraft fee
                super.withdrawal(30); // Deduct $30 fee
                System.out.println("Overdraft fee of $30 charged.");
            } else {
                super.withdrawal(amount);
            }
            totalWithdrawals += amount;
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to display the account details, including deposits, withdrawals, fees, and interest earned
    public void displayAccount() {
        System.out.println("\nAccount Name: " + getFirstName() + " " + getLastName());
        System.out.println("Account ID: " + getAccountID());
        System.out.println("\nBeginning Balance: $" + String.format("%.2f", 0.00));
        System.out.println("Deposits: $" + String.format("%.2f", totalDeposits));
        System.out.println("Withdrawals: $" + String.format("%.2f", totalWithdrawals));
        System.out.println("Fees: $" + String.format("%.2f", fees));
        double interest = calculateInterest();
        System.out.println("Interest Earned: $" + String.format("%.2f", interest));
        System.out.println("Ending Balance: $" + String.format("%.2f", getBalance() + interest));
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // Method to calculate the interest based on the interest rate
    private double calculateInterest() {
        if (getBalance() > 0) {
            return getBalance() * (interestRate / 100);
        }
        return 0;
    }
}
