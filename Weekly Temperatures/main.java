import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
     * This program stores and manages daily average temperatures for a week in Fahrenheit.
     * It performs the following tasks:
     * 1. Prompts the user to input average temperatures for each day of the week (Monday through Sunday) in Fahrenheit.
     * 2. Stores the days and their corresponding temperatures in two separate ArrayLists.
     * 3. Allows the user to either:
     *    - Enter a specific day of the week to display the temperature for that day, or
     *    - Enter "week" to display the temperature for each day and the average temperature for the entire week.
     * 4. Uses looping constructs to collect and display data, and decision constructs to handle user input and display results.
     */

    public static void main(String[] args) {
        // Create ArrayLists to store days of the week and their corresponding temperatures
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Declaration of the Array that stores each day of the week
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Step 1: Prompt the user to enter the average temperature for each day of the week in Fahrenheit
        Scanner scanner = new Scanner(System.in);
        for (String day : weekDays) {
            System.out.print("Enter the average temperature for " + day + " (in Fahrenheit): ");

            // Step 2: Stores the days and their corresponding temperatures in two seperate arrayLists as lowercase
            temperatures.add(scanner.nextDouble());
            days.add(day.toLowerCase());
        }
        scanner.nextLine();


        // Step 3: This Loop sequence is to collect temperatures until a valid day or the word "week" is entered
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a day of the week or 'week' to see the weekly average: ");
            input = scanner.nextLine().toLowerCase();  // Convert user input to lowercase

            // Check if the input is "week" or a valid day of the week
            if (input.equals("week")) {
                validInput = true;
            } else if (days.contains(input)) {
                validInput = true;
            } else {
                // Inform the user of the invalid input and prompt them to enter again
                System.out.println("Invalid day entered. Please enter a valid day of the week or 'week'.");
            }
        }


        // Process the valid user input
        if (input.equals("week")) {
            // Calculate and display temperatures for each day
            double total = 0;
            System.out.println("\nWeekly Temperatures:");
            for (int i = 0; i < days.size(); i++) {
                double temp = temperatures.get(i);
                System.out.println(weekDays[i] + ": " + temp + "°F"); // Use original case for display
                total += temp;  // Accumulate the total temperature
            }
            // Compute and display the weekly average temperature
            double average = total / days.size();
            System.out.println("Weekly Average Temperature: " + average + "°F");
        } else {
            // Display the temperature for the specified day
            int index = days.indexOf(input);
            if (index != -1) {
                System.out.println(weekDays[index] + ": " + temperatures.get(index) + "°F");
            }
        }
        scanner.close();
    }
}
