// Represents a cone shape with methods to calculate its surface area and volume
public class Cone extends Shape {
    private double radius; // Attribute for the radius of the cone
    private double height; // Attribute for the height of the cone

    // Constructor to initialize the radius and height
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Override the method to calculate surface area
    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    // Override the method to calculate volume
    @Override
    public double volume() {
        return (1 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    // Override the toString method to print surface area and volume
    @Override
    public String toString() {
        return "Cone - Surface Area: " + surfaceArea() + ", Volume: " + volume();
    }
}
