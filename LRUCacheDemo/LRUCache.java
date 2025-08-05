package LRUCacheDemo;

// Importing necessary Java utilities for the LinkedHashMap and Map interface
import java.util.LinkedHashMap;
import java.util.Map;

// LRUCache class extending LinkedHashMap to implement a Least Recently Used (LRU) cache
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    // Instance variable to store the maximum capacity of the cache
    private final int capacity;

    // Constructor to initialize the LRUCache with a specified capacity
    // Parameters:
    // - capacity: Maximum number of entries the cache can hold
    // - 0.75f: Load factor for the underlying LinkedHashMap
    // - true: Enables access-order mode (true) for LRU behavior, as opposed to insertion-order (false)
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // Override the removeEldestEntry method to implement LRU eviction policy
    // This method is called by LinkedHashMap after a new entry is added
    // Parameters:
    // - eldest: The least recently used entry (the oldest in access-order)
    // Returns:
    // - true if the eldest entry should be removed (when size exceeds capacity)
    // - false otherwise
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    // Main method to demonstrate the functionality of the LRUCache
    public static void main(String[] args) {
        // Create an LRUCache instance with a capacity of 3
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);

        // Add entries to the cache
        studentMap.put("Bob", 99);   // Cache: {Bob=99}
        studentMap.put("Alice", 34); // Cache: {Bob=99, Alice=34}
        studentMap.get("Bob");       // Access Bob, making it most recently used
        studentMap.put("Ram", 89);   // Cache: {Bob=99, Alice=34, Ram=89}
        studentMap.put("Shyam", 89); // Cache exceeds capacity, removes Alice (least recently used)
        // Cache: {Bob=99, Ram=89, Shyam=89}

        // Print the current state of the cache
        System.out.println("Current LRU Cache: " + studentMap);

        // Additional demonstration of cache behavior
        System.out.println("\nAccessing Bob again: " + studentMap.get("Bob")); // Bob becomes most recently used
        studentMap.put("Eve", 75);   // Cache exceeds capacity, removes Ram (least recently used)
        // Cache: {Bob=99, Shyam=89, Eve=75}
        System.out.println("After adding Eve: " + studentMap);
    }
}