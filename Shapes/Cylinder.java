// Represents a cylinder shape with methods to calculate its surface area and volume
public class Cylinder extends Shape {
    private double radius; // Attribute for the radius of the cylinder
    private double height; // Attribute for the height of the cylinder

    // Constructor to initialize the radius and height
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Override the method to calculate surface area
    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // Override the method to calculate volume
    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    // Override the toString method to print surface area and volume
    @Override
    public String toString() {
        return "Cylinder - Surface Area: " + surfaceArea() + ", Volume: " + volume();
    }
}
