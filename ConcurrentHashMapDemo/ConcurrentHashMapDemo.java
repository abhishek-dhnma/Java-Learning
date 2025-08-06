package ConcurrentHashMapDemo;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        // ConcurrentHashMap: Thread-safe Map implementation for high-concurrency environments.
        // - Does not allow null keys or values (throws NullPointerException).
        // - Uses fine-grained locking (bucket-level in Java 8, segment-level in Java 7).
        // - Average time complexity: O(1) for put/get/remove; O(log n) for high collisions in Java 8.
        // - Ideal for concurrent applications like caching or shared data structures.
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        // Default settings: initial capacity = 16, load factor = 0.75, concurrency level = 16.

        // Java 7 Internal Working:
        // - Uses segments (default 16), each with its own lock, acting as a mini-hash table.
        // - Concurrency level determines number of segments (power of 2).
        // - Collisions handled via linked lists in each segment.
        // - Segment-level locking allows concurrent access to different segments but may cause contention.

        // Java 8 Internal Working and Changes:
        // - Eliminates segments; uses a single hash table with bucket-level locking.
        // - Collisions: Linked lists for low collisions; red-black trees for high collisions (threshold ~8).
        // - Uses CAS (Compare-And-Swap) and synchronized blocks for bucket-level updates.
        // - Lock-free reads for better scalability; writes are thread-safe with minimal contention.
        // - Adds functional methods: forEach, compute, merge, reduce (supports Java 8 Streams/lambdas).

        // Insert initial key-value pairs.
        // - put(): Computes hash, places entry in bucket; O(1) average case, thread-safe.
        concurrentHashMap.put("A", 1); // Maps "A" to 1.
        concurrentHashMap.put("B", 2); // Maps "B" to 2.
        concurrentHashMap.put("C", 3); // Maps "C" to 3.
        concurrentHashMap.put("D", 4); // Maps "D" to 4.

        // Print initial map.
        // - Output: {A=1, B=2, C=3, D=4} (order not guaranteed).
        System.out.println("Initial ConcurrentHashMap: " + concurrentHashMap);

        // Create two threads to concurrently modify the map.
        // Thread 1: Increments values for keys "A" to "D" 1000 times using compute().
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                // compute(): Atomically updates value for a key; thread-safe.
                // - Lambda: (k, v) -> v + 1 increments the value.
                concurrentHashMap.compute("A", (k, v) -> v + 1);
                concurrentHashMap.compute("B", (k, v) -> v + 1);
            }
        });

        // Thread 2: Increments values for keys "C" and "D" 1000 times using merge().
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                // merge(): Combines value with a given value (1 here) using a function; thread-safe.
                // - Lambda: (oldVal, newVal) -> oldVal + newVal merges by adding.
                concurrentHashMap.merge("C", 1, (oldVal, newVal) -> oldVal + newVal);
                concurrentHashMap.merge("D", 1, (oldVal, newVal) -> oldVal + newVal);
            }
        });

        // Start both threads.
        t1.start();
        t2.start();

        // Wait for both threads to complete.
        // - join(): Ensures main thread waits for t1 and t2 to finish.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print final map and size.
        // - Expected: {A=1001, B=1002, C=1003, D=1004} (1000 increments + initial values).
        // - size(): Returns 4 (number of keys); thread-safe.
        System.out.println("Final ConcurrentHashMap: " + concurrentHashMap);
        System.out.println("Size: " + concurrentHashMap.size());

        // Java 8 Functional Example: Sum all values using reduce().
        // - mapping(): Maps entries to values; reduce() sums them.
        Integer sum = concurrentHashMap.reduceValues(1, Integer::sum);
        // Expected: 1001 + 1002 + 1003 + 1004 = 4010.
        System.out.println("Sum of values: " + sum);
    }
}