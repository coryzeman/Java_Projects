// Represents a sphere shape with methods to calculate its surface area and volume
public class Sphere extends Shape {
    private double radius; // Attribute for the radius of the sphere

    // Constructor to initialize the radius
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Override the method to calculate surface area
    @Override
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Override the method to calculate volume
    @Override
    public double volume() {
        return (4 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Override the toString method to print surface area and volume
    @Override
    public String toString() {
        return "Sphere - Surface Area: " + surfaceArea() + ", Volume: " + volume();
    }
}
