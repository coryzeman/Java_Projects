import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//This program allows the user to enter student data (name, address, GPA) and writes the data to a text file.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        // Loop to enter student data
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter student address: ");
            String address = scanner.nextLine();

            double GPA = -1;
            while (GPA < 0 || GPA > 4) {
                System.out.print("Enter student GPA (0.0 - 4.0): ");
                try {
                    GPA = Double.parseDouble(scanner.nextLine());
                    if (GPA < 0 || GPA > 4) {
                        System.out.println("Invalid GPA. Please enter a value between 0.0 and 4.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value between 0.0 and 4.0.");
                }
            }

            students.add(new Student(name, address, GPA));
        }

        // Sort the students by name
        Collections.sort(students);

        // Write to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to students.txt.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}

// This class represents a student with a name, address, and GPA.
class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    // Constructor to initialize the student object
    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    // Getters for the student attributes
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    // Override compareTo method to compare students by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    // Override toString method to return student data as a string
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}
