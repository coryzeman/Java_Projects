import java.util.Scanner;

// This program asks user to enter 5 numbers, then calculates the sum using a recursive method
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[5];                            // Creates the array used to store 5 numbers
        inputNums(scanner, numbers, 0);                            // Calls the recursive method to get the numbers

        double sum = calculateSum(numbers, 0);                     // Calls the recursive method to calculate the sum
        System.out.println("The sum of the numbers is: " + sum);   // Prints out the sum
    }

    // Recursive method to input numbers
    private static void inputNums(Scanner scanner, double[] numbers, int i) {
        if (i == numbers.length) {                                  // Base case to stop recursion
            return;
        } else {
            while (true) {
                System.out.println("Enter number " + (i + 1) + ":");
                if (scanner.hasNextDouble()) {
                    numbers[i] = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();  // Clear the invalid input
                }
            }
            inputNums(scanner, numbers, i + 1);                      // Recursive call to get the next number
        }
    }

    // Recursive method to calculate sum
    private static double calculateSum(double[] numbers, int i) {
        if (i == numbers.length) {                                  // Base case to stop recursion
            return 0;
        } else {
            return numbers[i] + calculateSum(numbers, i + 1);       // Recursive call to add the current number to the sum
        }
    }
}
