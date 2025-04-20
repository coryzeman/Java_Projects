public class Vehicle {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Vehicle() {
        this("", "", "", 0, 0);
    }

    // Parameterized constructor
    public Vehicle(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Method to add a new vehicle
    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added successfully.";
        } catch (Exception e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // Method to list vehicle information
    public String[] listVehicleInfo() {
        return new String[] {
                "Make: " + make,
                "Model: " + model,
                "Color: " + color,
                "Year: " + year,
                "Mileage: " + mileage
        };
    }

    // Method to remove a vehicle
    public String removeVehicle() {
        try {
            this.make = this.model = this.color = null;
            this.year = this.mileage = 0;
            return "Vehicle removed successfully.";
        } catch (Exception e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    // Method to update vehicle attributes
    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        return addVehicle(make, model, color, year, mileage);
    }
}
