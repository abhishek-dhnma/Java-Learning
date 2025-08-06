package ImmutableMapDemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo { // Fixed typo: "ImmutavbleMapDemo" → "ImmutableMapDemo"

    public static void main(String[] args) {
        // Create a mutable HashMap to store key-value pairs.
        // - HashMap: Non-thread-safe, allows one null key and multiple null values.
        // - Uses hash table with separate chaining (linked lists or trees in Java 8+).
        // - Time complexity: O(1) average case for put/get/remove; O(log n) worst case with tree bins.
        HashMap<String, Integer> map1 = new HashMap<>();

        // Populate map1 with key-value pairs.
        // - put(): Inserts or updates entries in O(1) average time.
        map1.put("scd", 56);    // Key: "scd", Value: 56
        map1.put("ibcwe", 93);  // Key: "ibcwe", Value: 93
        map1.put("sdfw", 832);  // Key: "sdfw", Value: 832

        // WAY 1: Create an immutable view of map1 using Collections.unmodifiableMap.
        // - Why? To prevent modifications (put, remove, clear) to the map, ensuring data integrity.
        // - How it works: Wraps map1 in a read-only view; any modification attempt throws UnsupportedOperationException.
        // - Limitation: map2 is a view of map1. Changes to map1 (e.g., map1.put("new", 100)) affect map2.
        // - Use case: Share an existing map safely without copying, but requires trust that map1 won’t be modified.
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        // Output: {scd=56, ibcwe=93, sdfw=832} (order not guaranteed due to HashMap).
        System.out.println("Immutable view of map1 (Way 1): " + map2);

        // Attempting to modify map2 throws UnsupportedOperationException.
        // - Example: map2.put("cw", 34); // Throws exception because map2 is immutable.
        // - However, modifying map1 (e.g., map1.put("cw", 34)) will reflect in map2.
        // map2.put("cw", 34); // Uncommenting this would throw UnsupportedOperationException.

        // WAY 2: Create an immutable map using Map.of (Java 9+).
        // - Why better? Creates a new, independent map that’s immutable from the start; no underlying mutable map.
        // - How it works: Optimized internal representation for small maps (up to 10 entries in Java 9).
        // - Limitations:
        //   - Fixed size (up to 10 key-value pairs in Java 9; later versions optimize further).
        //   - No null keys or values (throws NullPointerException).
        //   - Cannot be modified after creation (immutable).
        // - Use case: Small, fixed-size maps with concise syntax; ideal for constants or configuration data.
        Map<String, Integer> map3 = Map.of("Mukul", 89, "Rahul", 872, "Srini", 872);
        // Output: {Mukul=89, Rahul=872, Srini=872} (order not guaranteed).
        System.out.println("Immutable map with Map.of (Way 2): " + map3);

        // WAY 3: Create an immutable map using Map.ofEntries (Java 9+).
        // - Why better than Way 2? Supports any number of entries (no 10-pair limit).
        // - How it works: Takes Map.Entry objects to build an immutable map; more flexible for large maps.
        // - Limitations: No null keys or values; immutable after creation.
        // - Use case: Large immutable maps or when entries are dynamically generated.
        Map<String, Integer> map4 = Map.ofEntries(
                Map.entry("nusdu", 89),   // Key: "nusdu", Value: 89
                Map.entry("buerb", 8734), // Key: "buerb", Value: 8734
                Map.entry("incwn", 987)   // Key: "incwn", Value: 987
        );
        // Output: {nusdu=89, buerb=8734, incwn=987} (order not guaranteed).
        System.out.println("Immutable map with Map.ofEntries (Way 3): " + map4);
    }
}