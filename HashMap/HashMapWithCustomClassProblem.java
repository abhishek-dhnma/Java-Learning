package HashMap;

import java.util.HashMap;

public class HashMapWithCustomClassProblem {

    public static void main(String[] args) {

        // WHY: We're using a HashMap with a custom class (Student) as keys.
        // This is to test whether two objects with the same content are treated as equal keys.
        HashMap<Student, String> studentHashMap = new HashMap<>();

        // Creating student objects with some duplicate data (s1 and s4 are identical in content)
        Student s1 = new Student("Neha", 101, "Designer");
        Student s2 = new Student("Rahul", 322, "Engineer");
        Student s3 = new Student("Sunil", 782, "HR");

        // s4 has the same data as s1 but is a different object in memory (new keyword)
        Student s4 = new Student("Neha", 101, "Designer");

        // Adding entries to the HashMap
        studentHashMap.put(s1, "Working");  // Adds entry for s1
        studentHashMap.put(s2, "OOO");      // Adds entry for s2
        studentHashMap.put(s3, "Working");  // Adds entry for s3

        // Adds s4 as a new key, even though it looks identical to s1.
        // WHY: Because Student does NOT override equals() and hashCode(),
        // HashMap uses the default implementation (object reference comparison),
        // treating s4 as a DIFFERENT key from s1.
        studentHashMap.put(s4, "Leave");

        // Expected size should be 3, but output will be 4 due to lack of equals/hashCode
        System.out.println(studentHashMap.size());

        // Print values for both s1 and s4
        // They are different keys, so both entries exist independently
        System.out.println("s1 value :" + s1.getName() + " " + studentHashMap.get(s1));
        System.out.println("s4 value :" + s4.getName() + " " + studentHashMap.get(s4));

        // WHY THIS MATTERS:
        // Even though s1 and s4 have the same content, they are treated as different keys
        // This breaks expected behavior when using custom objects in maps or sets.

        // Educating the user on the issue and hinting at the solution
        System.out.println("Size should be 3 not 4 and Neha status should change from working to leave because here we are using 'new' keyword " +
                "which creates new memory references. Since the class doesn't override equals() and hashCode(), " +
                "the HashMap treats s1 and s4 as different keys. " +
                "\nHOW TO OVERCOME THIS??????? => Override equals() and hashCode() methods in Student class.");
    }
}

// Custom class used as key in HashMap
class Student {

    private int id;
    private String name;
    private String job;

    // Constructor
    public Student(String name, int id, String job){
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

    // toString override to help print student details clearly
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    /*
     * MISSING:
     * Without overriding equals() and hashCode(), the HashMap uses default Object methods,
     * which compare memory references (not logical values).
     *
     * To fix this problem:
     * 1. Override equals() to compare fields like id and name.
     * 2. Override hashCode() so that logically equal objects go to the same bucket.
     *
     * See: HashMapWithCustomClassSolution.java for a working example.
     */
}
