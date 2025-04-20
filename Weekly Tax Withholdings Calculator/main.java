import java.util.Scanner;

/**
 * This program calculates weekly tax withholding based on the user's income.
 * Tax rates are applied as follows:
 * - Less than $500: 10%
 * - $500 to $1499: 15%
 * - $1500 to $2499: 20%
 * - $2500 and above: 30%
 */
public class Main {

    public static void main(String[] args) {
        // Initialize a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Invokes the getIncome method to retrieve the user's input and stores the result in the income variable
        double income = getIncome(scanner);

        // Invokes the calculateTaxRate method to determine the tax rate and assigns the result to the taxRate variable
        double taxRate = calculateTaxRate(income);

        // Invokes the computeTaxWithholding method and assigns the result to the taxWithholding variable
        double taxWithholding = computeTaxWithholding(income, taxRate);

        // Invokes the displayTaxWithholding method for output
        displayTaxWithholding(income, taxWithholding, taxRate);

        // Close the scanner
        scanner.close();
    }

    // This Method prompts user to input weekly salary
    private static double getIncome(Scanner scanner) {
        double income = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the weekly income: $");
            try {
                income = scanner.nextDouble();
                if (income < 0) {
                    System.out.println("Income cannot be negative. Please enter a valid income.");
                } else {
                    validInput = true; // Valid input received
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear the invalid input
            }
        }
        return income;
    }

    // This Method is used to determine and return the tax rate based on income
    private static double calculateTaxRate(double income) {
        if (income < 500) {
            return 10.0;
        } else if (income < 1500) {
            return 15.0;
        } else if (income < 2500) {
            return 20.0;
        } else {
            return 30.0;
        }
    }

    // This Method is used to calculate Tax Withholding
    private static double computeTaxWithholding(double income, double taxRate) {
        return income * taxRate / 100;
    }

    /*
     * This Method outputs:
     * - the assigned Income rounded to 2 decimal places
     * - the assigned Tax Rate rounded to 1 decimal place
     * - the calculated Tax Withholding rounded to 2 decimal places
     */
    private static void displayTaxWithholding(double income, double taxWithholding, double taxRate) {
        System.out.printf("The weekly income is $%.2f.\n", income);
        System.out.printf("The tax rate used is %.1f%%.\n", taxRate);
        System.out.printf("The weekly tax withholding is $%.2f.\n", taxWithholding);
    }
}
