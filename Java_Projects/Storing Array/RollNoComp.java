import java.util.Comparator;
/**
 * Comparator class to compare Student objects based on their roll numbers.
 * This comparator is used to sort a list of Student objects by their roll numbers.
 */
public class RollNoComp implements Comparator<Main.Student> {
    // Overriding the compare method to compare two Student objects by their roll numbers
    @Override
    public int compare(Main.Student s1, Main.Student s2) {
        // Using Integer.compare to compare the roll numbers of the two students
        return Integer.compare(s1.rollno, s2.rollno);
    }
}