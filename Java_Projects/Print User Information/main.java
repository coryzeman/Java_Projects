import java.util.Scanner;

public class Main {
    /*
     * This program prompts the user to enter their first name, last name, street address,
     * city, and zip code. It then prints out this information on individual lines.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for first name
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        // Prompt user for last name
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Prompt user for street address
        System.out.print("Enter your street address: ");
        String streetAddress = scanner.nextLine();

        // Prompt user for city
        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        // Prompt user for zip code
        System.out.print("Enter your zip code: ");
        String zipCode = scanner.nextLine();

        // Print out the information
        System.out.println("\nYou entered the following information:");
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Street address: " + streetAddress);
        System.out.println("City: " + city);
        System.out.println("Zip code: " + zipCode);

        // Close the scanner
        scanner.close();
    }
}
