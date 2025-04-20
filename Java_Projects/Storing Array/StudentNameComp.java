import java.util.Comparator;
/**
 * Comparator class to compare Student objects based on their names.
 * This comparator is used to sort a list of Student objects by their names.
 */
public class StudentNameComp implements Comparator<Main.Student> {
    // Overriding the compare method to compare two Student objects by their names
    @Override
    public int compare(Main.Student s1, Main.Student s2) {
        // Using String's compareTo method to compare the names of the two students
        return s1.name.compareTo(s2.name);
    }
}