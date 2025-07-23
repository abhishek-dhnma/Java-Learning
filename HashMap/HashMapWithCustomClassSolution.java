package HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashMapWithCustomClassSolution {

    public static void main(String[] args) {

        // WHY: We're creating a HashMap where the key is a custom object (StudentSolution).
        // This is to understand how HashMap behaves when custom objects are used as keys.
        HashMap<StudentSolution, String> studentHashMap = new HashMap<>();

        // WHY: Creating different student objects to test key uniqueness and equality
        StudentSolution s1 = new StudentSolution("Neha", 101, "Designer");
        StudentSolution s2 = new StudentSolution("Rahul", 322, "Engineer");
        StudentSolution s3 = new StudentSolution("Sunil", 782, "HR");

        // WHY: s4 is deliberately made with the same data as s1 to test if HashMap
        // treats them as the same key (i.e., whether s4 will overwrite s1's entry)
        StudentSolution s4 = new StudentSolution("Neha", 101, "Designer");

        // WHY: Adding student entries to the HashMap.
        // This tests whether custom keys behave like expected (based on equals & hashCode)
        studentHashMap.put(s1, "Working");  // Adding s1
        studentHashMap.put(s2, "OOO");      // Adding s2
        studentHashMap.put(s3, "Working");  // Adding s3

        // WHY: Adding s4 will only overwrite s1's value **if** equals() and hashCode() are implemented correctly.
        // If not, it will insert as a separate key.
        studentHashMap.put(s4, "Leave");

        // WHY: Printing size tells us if the map treated s1 and s4 as one key or two.
        // If size = 3, then s1 and s4 are considered equal keys (overwritten).
        System.out.println(studentHashMap.size());

        // WHY: Verifying if we get the updated value ("Leave") from both s1 and s4 as keys
        System.out.println("s1 value :" + s1.getName() + " " + studentHashMap.get(s1));
        System.out.println("s4 value :" + s4.getName() + " " + studentHashMap.get(s4));

        // WHY: Redundant prints to confirm consistency of retrieval
        System.out.println("s1 value :" + s1.getName() + " " + studentHashMap.get(s1));
        System.out.println("s4 value :" + s4.getName() + " " + studentHashMap.get(s4));
    }
}

/**
 * Custom class StudentSolution to be used as a key in HashMap.
 * WHY: To test how HashMap works with objects we define ourselves.
 */
class StudentSolution {

    private int id;
    private String name;
    private String job;

    // Constructor
    public StudentSolution(String name, int id, String job){
        this.name = name;
        this.id = id;
        this.job = job;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * WHY: hashCode() is used by HashMap to place the key in a bucket.
     * We override it so that two logically equal StudentSolution objects
     * go to the same bucket and can be compared via equals().
     */
    @Override
    public int hashCode() {
        // Using name and id (but not job) to compute hash
        return Objects.hash(name, id);
    }

    /**
     * WHY: equals() checks if two StudentSolution objects are logically equal.
     * If not overridden, default equals checks object references (i.e., memory address).
     * Overriding it allows the HashMap to treat s1 and s4 as the same key.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;  // Same memory reference
        }

        if (obj == null || getClass() != obj.getClass()){
            return false; // Different type or null
        }

        StudentSolution other = (StudentSolution) obj;

        // All fields must match for objects to be considered equal
        return id == other.getId()
                && Objects.equals(name, other.name)
                && Objects.equals(job, other.job);
    }

    /**
     * WHY: Overriding toString() helps print Student objects clearly.
     * Useful for debugging and logging.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
