package WeakHashMap;

// Importing necessary Java utilities for WeakHashMap and Map
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMaps {

    public static void main(String[] args) {
        // Create a WeakHashMap to store key-value pairs where keys are weakly referenced
        // WeakHashMap allows keys to be garbage collected if no strong references exist
        WeakHashMap<String, String> imageCache = new WeakHashMap<>();

        // Load initial data into the WeakHashMap
        loadData(imageCache);
        System.out.println("WeakHashMap after loading data: " + imageCache);

        // Request garbage collection (hint to JVM, not guaranteed)
        System.out.println("Requesting garbage collection...");
        System.gc();

        // Simulate application work with a delay to give garbage collector a chance to run
        applicationSimulation();

        // Print the WeakHashMap after garbage collection
        // Expected: Map may be empty or have fewer entries if keys were garbage collected
        System.out.println("WeakHashMap after GC and simulation: " + imageCache);
    }

    // Method to populate the WeakHashMap with sample data
    private static void loadData(WeakHashMap<String, String> imageCache) {
        // Note: Using 'new String()' creates new String objects with no strong references
        // These keys are eligible for garbage collection
        imageCache.put(new String("img1"), new String("Image 1"));
        imageCache.put(new String("img2"), new String("Image 2"));
    }

    // Method to simulate application work with a delay
    private static void applicationSimulation() {
        System.out.println("Application is working...");
        try {
            // Sleep for 10 seconds to increase the chance of garbage collection
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException("Error during simulation: " + e.getMessage());
        }
    }
}

// Class to represent an image (currently unused in the main program)
// Included for potential future use or demonstration
class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }


}