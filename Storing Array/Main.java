import java.util.ArrayList;
import java.util.Comparator;
/**
 * This program demonstrates the creation and manipulation of a list of Student objects.
 * It includes sorting the list by student names and roll numbers using custom comparators.
 * The sorting is performed using a selection sort algorithm.
 */
public class Main {
    static class Student {
        int rollno;
        String name;
        String address;

        // Constructor to initialize the Student object
        public Student(int rollno, String name, String address) {
            this.rollno = rollno;
            this.name = name;
            this.address = address;
        }

        // Overriding toString method to provide a custom string representation of the Student object
        @Override
        public String toString() {
            return "Roll No: " + rollno + ", Name: " + name + ", Address: " + address;
        }
    }

    public static void main(String[] args) {
        // Creating an ArrayList to store Student objects
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(3, "Adam", "1600 Pennsylvania Avenue"));
        students.add(new Student(1, "Eve", "221B Baker Street"));
        students.add(new Student(2, "Christopher", "1 Infinite Loop"));
        students.add(new Student(5, "Daniel", "1600 Amphitheatre Parkway"));
        students.add(new Student(4, "Emily", "350 5th Avenue"));
        students.add(new Student(6, "Ford", "987 Spruce Drive"));
        students.add(new Student(10, "Gabriela", "654 Elm Street"));
        students.add(new Student(7, "Hannah", "321 Water Street"));
        students.add(new Student(8, "Isabelle", "789 Thunderbird Drive"));
        students.add(new Student(9, "Johnny", "123 Downer Street"));

        // Printing the original list of students
        System.out.println("Original List:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sorting the list by student names using StudentNameComp comparator
        selectionSort(students, new StudentNameComp());
        System.out.println("\nSorted by Name:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sorting the list by roll numbers using RollNoComp comparator
        selectionSort(students, new RollNoComp());
        System.out.println("\nSorted by Roll Number:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Selection sort method to sort the list based on the provided comparator
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
        int n = list.size();

        // One by one move the boundary of the unsorted sub array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            Student temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}