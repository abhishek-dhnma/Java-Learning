package ConcurrentSkipListMapDemo;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        // Concept: ConcurrentSkipListMap Overview
        // - A thread-safe, sorted Map implementing ConcurrentNavigableMap, NavigableMap, and SortedMap interfaces.
        // - Designed for high-concurrency environments, providing lock-free reads and fine-grained synchronization for writes.
        // - Keys are maintained in sorted order (natural order or custom Comparator).
        // - Does not allow null keys or values (throws NullPointerException).
        // - Use case: Concurrent applications needing sorted keys, range queries, or navigational operations (e.g., leaderboards, event scheduling).

        // Concept: Skip List Data Structure
        // - ConcurrentSkipListMap uses a skip list, a probabilistic data structure with multiple layers of linked lists.
        // - Each node contains a key-value pair and pointers to nodes at the same or lower levels.
        // - Higher levels act as "express lanes" for faster traversal, with levels assigned randomly (probabilistic balancing).
        // - Average time complexity: O(log n) for search, insert, delete; O(n) worst case (rare due to randomization).
        // - Advantages: Simpler to implement for concurrency than balanced trees (e.g., Red-Black Tree in TreeMap).

        // Concept: Thread Safety
        // - Uses lock-free algorithms (Compare-And-Swap, CAS) for reads and fine-grained synchronization for writes.
        // - More scalable than Hashtable (full-table locking) or Collections.synchronizedMap(TreeMap) (coarse-grained locking).
        // - Reads (e.g., get, containsKey) are typically lock-free; writes (e.g., put, remove) use CAS or minimal locks.
        // - Ideal for high-concurrency environments with frequent reads and writes.

        // Concept: Time Complexity
        // - Search, insert, delete: O(log n) average case due to skip list traversal.
        // - Range queries (e.g., headMap, tailMap): O(log n + k), where k is the number of elements in the range.
        // - Iteration: O(n), in sorted key order.
        // - Slower than ConcurrentHashMap (O(1) average) but provides sorted order and navigational features.

        // Concept: NavigableMap Features
        // - Extends SortedMap with navigation methods: lowerKey, ceilingKey, firstEntry, lastEntry, etc.
        // - Supports range queries: headMap, tailMap, subMap.
        // - All operations are thread-safe, making it suitable for concurrent sorted data access.
        // - Example: ceilingKey("g") finds the smallest key >= "g"; headMap("jbh") returns entries with keys < "jbh".

        // Create a ConcurrentSkipListMap with String keys and Integer values.
        // - Uses natural ordering for keys (alphabetical for Strings via compareTo).
        // - Skip list is initialized with nodes for key-value pairs, with randomized levels for efficient traversal.
        // - Thread-safe: Supports concurrent modifications without external synchronization.
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();

        // Concept: Insertion (put)
        // - put(): Inserts or updates a key-value pair in O(log n) average time.
        // - Traverses the skip list to find the correct position, using CAS for thread-safe insertion.
        // - Keys are sorted: "fcinh" < "hs" < "jbh" (alphabetical order for Strings).
        // - Null keys or values throw NullPointerException.
        map.put("hs", 3);      // Maps "hs" to 3.
        map.put("jbh", 5);     // Maps "jbh" to 5.
        map.put("fcinh", 564); // Maps "fcinh" to 564.

        // Concept: Sorted Output
        // - toString(): Displays entries in sorted key order (natural order or Comparator).
        // - Unlike HashMap or ConcurrentHashMap (unordered), keys are sorted: "fcinh" < "hs" < "jbh".
        // - Output: {fcinh=564, hs=3, jbh=5}
        System.out.println("ConcurrentSkipListMap contents: " + map);

        // Concept: Navigational Methods
        // - ceilingKey(key): Returns the smallest key >= given key, or null if none (O(log n)).
        // - Example: ceilingKey("g") returns "hs" (smallest key >= "g" alphabetically).
        System.out.println("Ceiling key for 'g': " + map.ceilingKey("g"));

        // - lowerKey(key): Returns the largest key < given key, or null if none (O(log n)).
        // - Example: lowerKey("jbh") returns "hs" (largest key < "jbh").
        System.out.println("Lower key for 'jbh': " + map.lowerKey("jbh"));

        // - headMap(toKey): Returns a view of entries with keys < toKey (O(log n) to create view).
        // - Example: headMap("jbh") includes {fcinh=564, hs=3}.
        // - View is thread-safe; changes to map reflect in the view.
        System.out.println("Head map (keys < 'jbh'): " + map.headMap("jbh"));

        // Concept: Comparison with Other Maps
        // - HashMap (ImmutableMapDemo): Mutable, not thread-safe, O(1) average, unordered, allows one null key.
        // - Hashtable (HashTableDemo): Thread-safe, coarse-grained locking, no nulls, slower than ConcurrentSkipListMap.
        // - ConcurrentHashMap (ConcurrentHashMapDemo): Thread-safe, O(1) average, unordered, no nulls, faster for unsorted data.
        // - EnumMap (EnumMapDemo): Mutable, not thread-safe, O(1), ordered by enum, enum keys only.
        // - Immutable Maps (ImmutableMapDemo): Read-only, not thread-safe for modifications, no dynamic updates.
        // - TreeMap (SortedMapDemo): Non-thread-safe, O(log n), sorted, uses Red-Black Tree, not concurrent.

        // Concept: Use Cases
        // - Concurrent leaderboards (sorted by score).
        // - Event scheduling with sorted timestamps.
        // - Range queries in multithreaded applications (e.g., entries within a key range).
        // - Navigational queries (e.g., finding nearest keys in a concurrent environment).

        // Concept: Limitations
        // - Slower than ConcurrentHashMap for unsorted data (O(log n) vs. O(1)).
        // - No null keys or values (throws NullPointerException).
        // - Probabilistic performance: O(log n) average, O(n) worst case (rare).
        // - Not immutable; wrap with Collections.unmodifiableMap for immutability.

        // Concept: Thread-Safe Alternatives
        // - For immutable sorted map: Collections.unmodifiableMap(new TreeMap<>(map)).
        // - For non-concurrent sorted map: Use TreeMap (SortedMapDemo) for single-threaded use.
        // - For unsorted concurrent map: Use ConcurrentHashMap (ConcurrentHashMapDemo).
    }
}