import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = new Vehicle("Toyota", "Camry", "Red", 2020, 15000);

        try {
            // Listing vehicle information
            System.out.println("Listing Vehicle Information:");
            for (String info : vehicle.listVehicleInfo()) {
                System.out.println(info);
            }

            // Removing the vehicle
            System.out.println("\nRemoving Vehicle:");
            System.out.println(vehicle.removeVehicle());

            // Adding a new vehicle
            System.out.println("\nAdding a New Vehicle:");
            System.out.println(vehicle.addVehicle("Honda", "Accord", "Blue", 2021, 10000));

            // Listing new vehicle information
            System.out.println("New Vehicle Information:");
            for (String info : vehicle.listVehicleInfo()) {
                System.out.println(info);
            }

            // Updating vehicle attributes
            System.out.println("\nUpdating Vehicle Attributes:");
            System.out.println(vehicle.updateVehicleAttributes("Nissan", "Altima", "Black", 2022, 5000));

            // Listing updated vehicle information
            System.out.println("Updated Vehicle Information:");
            for (String info : vehicle.listVehicleInfo()) {
                System.out.println(info);
            }

            // Asking if user wants to print the information to a file
            System.out.print("\nDo you want to print the information to a file (Y/N)? ");
            if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                try (FileWriter writer = new FileWriter("C:\\Users\\Cory\\IdeaProjects\\Auto Inventory\\Autos.txt")) {
                    for (String info : vehicle.listVehicleInfo()) {
                        writer.write(info + System.lineSeparator());
                    }
                    System.out.println("Vehicle information printed to file.");
                } catch (IOException e) {
                    System.out.println("Failed to write to file: " + e.getMessage());
                }
            } else {
                System.out.println("File will not be printed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
