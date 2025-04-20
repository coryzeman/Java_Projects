// Driver class to instantiate and store shapes, and print their details
public class ShapeArray {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = new Shape[3];

        // Instantiate a Sphere, Cylinder, and Cone
        shapes[0] = new Sphere(3);
        shapes[1] = new Cylinder(2, 5);
        shapes[2] = new Cone(2, 4);

        // Loop through the array and print the details of each shape
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
}
