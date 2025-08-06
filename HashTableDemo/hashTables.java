package HashTableDemo;

import java.util.Hashtable;

public class hashTables {
    public static void main(String[] args) {
        // Hashtable: Legacy class implementing Map, storing key-value pairs in a hash table.
        // - Thread-safe: All methods are synchronized, suitable for concurrent access.
        // - Does not allow null keys or values (throws NullPointerException).
        // - Uses separate chaining (linked lists) to handle hash collisions.
        // - Default initial capacity: 11, load factor: 0.75 (resizes when 75% full).
        // - Superseded by HashMap (non-synchronized) or ConcurrentHashMap (modern concurrent alternative).
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // Insert key-value pairs into the hashtable.
        // - put(): Computes hash of key, places entry in appropriate bucket; O(1) average case.
        // - Synchronized, so safe for concurrent modifications.
        // - Throws NullPointerException if key or value is null.
        hashtable.put(3, "eojfi");   // Maps 3 to "eojfi".
        hashtable.put(34, "htwr");   // Maps 34 to "htwr".
        hashtable.put(54, "fef");    // Maps 54 to "fef".
        hashtable.put(3894, "sfer"); // Maps 3894 to "sfer".

        // Print the hashtable.
        // - Output: {3894=sfer, 54=fef, 34=htwr, 3=eojfi} (order not guaranteed).
        // - Order depends on hash values, not insertion order.
        System.out.println("Hashtable after initial puts: " + hashtable);

        // Thread t1: Inserts 1000 entries (keys 0 to 999, value "t1").
        // - Runs concurrently with t2, safely modifying hashtable due to synchronization.
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashtable.put(i, "t1"); // O(1) average case per put, synchronized.
            }
        });

        // Thread t2: Inserts 1000 entries (keys 1000 to 1999, value "t1").
        // - Runs concurrently with t1, safely modifying hashtable.
        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                hashtable.put(i, "t1"); // O(1) average case per put, synchronized.
            }
        });

        // Start both threads to perform concurrent insertions.
        t1.start();
        t2.start();

        // Wait for both threads to complete using join().
        // - Ensures main thread waits until t1 and t2 finish inserting entries.
        // - Catches InterruptedException and wraps it in a RuntimeException.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print the size of the hashtable.
        // - Expected size: 2004 (4 initial entries + 1000 from t1 + 1000 from t2).
        // - size() is synchronized, ensuring accurate count in concurrent environment.
        System.out.println("Hashtable size after concurrent inserts: " + hashtable.size());
    }
}