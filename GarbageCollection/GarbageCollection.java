package GarbageCollection;

// Importing WeakReference for demonstrating weak references in garbage collection
import java.lang.ref.WeakReference;

public class GarbageCollection {

    public static void main(String[] args) {
        // Create a strong reference to a Phone object
        // Strong references prevent the object from being garbage collected
        Phone phone = new Phone("Apple", "13", 2022);
        System.out.println("Strong reference to Phone: " + phone);

        // Create a WeakReference to a new Phone object
        // Weak references allow the object to be garbage collected if no strong references exist
        WeakReference<Phone> weakReference = new WeakReference<>(new Phone("Nokia", "3320", 2009));
        System.out.println("Weak reference before GC: " + weakReference.get());

        // Request garbage collection (note: this is a hint to the JVM, not guaranteed)
        System.out.println("Requesting garbage collection...");
        System.gc();

        // Pause execution to give the garbage collector a chance to run
        // 10-second sleep to increase the likelihood of garbage collection
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException("Error during sleep: " + e.getMessage());
        }

        // Check if the weakly referenced object is still available
        // Expected: Likely null, as the object may have been garbage collected
        System.out.println("Weak reference after GC: " + weakReference.get());

        // Demonstrate that the strong reference is still intact
        System.out.println("Strong reference after GC: " + phone);
    }
}

// Phone class to represent a simple object for garbage collection demonstration
class Phone {
    private String name;
    private String model;
    private Integer year;

    // Constructor to initialize Phone object
    public Phone(String name, String model, Integer year) {
        this.name = name;
        this.model = model;
        this.year = year;
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

}