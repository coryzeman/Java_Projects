import java.util.Scanner;

/**
 * This program prompts the user to enter five floating-point values.
 * It uses a while loop to repeatedly ask for input until the required number
 * of values (defined by NUMBER_OF_VALUES) is obtained.
 * After collecting the inputs, the program calculates the total, average,
 * maximum, and minimum values. It also computes the interest on the total
 * amount at a rate of 20%. Finally, it prints the results to the user.
 */
public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Define the number of floating-point values to be entered
        final int NUMBER_OF_VALUES = 5;

        // Initialize variables for total, maximum, and minimum values
        float total = 0.0f;
        float max = Float.NEGATIVE_INFINITY; // Start with the lowest possible float value
        float min = Float.POSITIVE_INFINITY; // Start with the highest possible float value
        int count = 0; // Count of valid inputs received

        // Prompt user to enter floating-point values and process them
        while (count < NUMBER_OF_VALUES) {
            float value = getInputValue(scanner);
            total += value;

            // Update maximum and minimum values
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }

            count++;
        }

        // Close the scanner to release the resources
        scanner.close();

        // Calculate the average of the entered values
        float average = total / NUMBER_OF_VALUES;

        // Calculate the interest on the total amount at a rate of 20%
        float interest = total * 0.20f;

        // Print results
        System.out.printf("Total: %.2f%n", total);
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Maximum: %.2f%n", max);
        System.out.printf("Minimum: %.2f%n", min);
        System.out.printf("Interest on total at 20%%: %.2f%n", interest);
    }

    // This method prompts user to input a floating-point value and checks for validity
    private static float getInputValue(Scanner scanner) {
        float value;
        while (true) {
            System.out.print("Enter floating-point value: ");
            if (scanner.hasNextFloat()) {
                value = scanner.nextFloat();
                return value; // Exit loop on valid input (including negative values)
            } else {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
