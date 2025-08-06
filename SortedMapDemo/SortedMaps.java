package SortedMapDemo;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMaps {
    public static void main(String[] args) {
        // SortedMap: Interface that extends Map, maintaining keys in sorted order (natural or custom).
        // - Ensures keys are ordered for efficient range queries (e.g., headMap, tailMap).
        // - Does not allow null keys; allows null values in some implementations.
        // - Common implementation: TreeMap.
        SortedMap<Integer, String> sortedMap = new TreeMap<>((a, b) -> b - a);
        // TreeMap: Implements SortedMap and NavigableMap, using a Red-Black Tree internally.
        // - Red-Black Tree ensures O(log n) time for insertion, deletion, and retrieval.
        // - Custom comparator (a, b) -> b - a sorts keys in descending order (e.g., 93, 90, 78, 67).
        // - Without a comparator, TreeMap uses natural ordering (ascending for Integers).

        // Insert key-value pairs into sortedMap.
        // - put(): Adds or updates entries in O(log n) due to Red-Black Tree balancing.
        sortedMap.put(78, "Sham"); // Maps 78 to "Sham".
        sortedMap.put(90, "Ram");  // Maps 90 to "Ram".
        sortedMap.put(93, "Hari"); // Maps 93 to "Hari".
        sortedMap.put(67, "Yamini"); // Maps 67 to "Yamini".

        // Print sortedMap: Shows keys in descending order due to custom comparator.
        // Output: {93=Hari, 90=Ram, 78=Sham, 67=Yamini}
        System.out.println("SortedMap (descending order): " + sortedMap);

        // headMap(toKey): Returns a view of entries with keys < toKey (80 here).
        // - O(log n) for creating the view; changes to view affect original map.
        // Output: {78=Sham, 67=Yamini}
        System.out.println("headMap(80): " + sortedMap.headMap(80));

        // tailMap(fromKey): Returns a view of entries with keys >= fromKey (80 here).
        // - O(log n) for creating the view; changes to view affect original map.
        // Output: {93=Hari, 90=Ram}
        System.out.println("tailMap(80): " + sortedMap.tailMap(80));

        // NavigableMap: Extends SortedMap, adds navigation methods for finding closest keys/entries.
        // - Provides methods like lowerKey, ceilingEntry, higherEntry for precise key navigation.
        // - Useful for applications needing nearest-match lookups (e.g., range queries, leaderboards).
        // - TreeMap is the primary implementation, also using a Red-Black Tree.
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        // TreeMap here uses natural ordering (ascending for Integers) since no comparator is provided.
        // - Thread-unsafe; use ConcurrentSkipListMapDemo for concurrent access.
        // - Null keys are not allowed; null values are permitted.

        // Insert key-value pairs into navigableMap.
        // - put(): O(log n) for each insertion.
        navigableMap.put(1, "we");    // Maps 1 to "we".
        navigableMap.put(6, "eds");   // Maps 6 to "eds".
        navigableMap.put(9, "fuel");  // Maps 9 to "fuel".
        navigableMap.put(67, "bmw");  // Maps 67 to "bmw".

        // lowerKey(key): Returns greatest key strictly < key (3 here).
        // - O(log n) to traverse the Red-Black Tree.
        // - Output: 1 (greatest key < 3).
        System.out.println("lowerKey(3): " + navigableMap.lowerKey(3));

        // ceilingEntry(key): Returns entry with least key >= key (3 here).
        // - O(log n) to find the entry.
        // - Output: 6=eds (smallest key >= 3).
        System.out.println("ceilingEntry(3): " + navigableMap.ceilingEntry(3));

        // ceilingKey(key): Returns least key >= key (9 here).
        // - O(log n); returns key only, not the entry.
        // - Output: 9 (since 9 exists).
        System.out.println("ceilingKey(9): " + navigableMap.ceilingKey(9));

        // higherEntry(key): Returns entry with least key strictly > key (7 here).
        // - O(log n) to navigate the tree.
        // - Output: 9=fuel (smallest key > 7).
        System.out.println("higherEntry(7): " + navigableMap.higherEntry(7));
    }
}