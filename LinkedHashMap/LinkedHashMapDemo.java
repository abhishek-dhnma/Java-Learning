package LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// Class to demonstrate the usage of LinkedHashMap and HashMap
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // === LinkedHashMap Demonstration ===
        // LinkedHashMap maintains insertion order (or access order if specified).
        // Constructor: LinkedHashMap(initialCapacity, loadFactor, accessOrder)
        // - initialCapacity: Initial number of buckets (11 here).
        // - loadFactor: When map is filled to this ratio (0.5), it resizes.
        // - accessOrder: true for access-order (LRU), false for insertion-order.
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.5f, true);

        // Adding key-value pairs to LinkedHashMap
        linkedHashMap.put("Apple", 34);      // Adds Apple with value 34
        linkedHashMap.put("Mango", 90);      // Adds Mango with value 90
        linkedHashMap.put("Strawberry", 54); // Adds Strawberry with value 54
        linkedHashMap.put("Guava", 23);      // Adds Guava with value 23
        linkedHashMap.put("Orange", 18);     // Adds Orange with value 18

        // Accessing elements to demonstrate LRU (Least Recently Used) behavior
        // Since accessOrder is true, accessing elements reorders them based on access
        linkedHashMap.get("Apple");    // Moves Apple to the end (most recently used)
        linkedHashMap.get("Orange");   // Moves Orange to the end
        linkedHashMap.get("Mango");    // Moves Mango to the end
        linkedHashMap.get("Mango");    // Mango already at the end, no change
        linkedHashMap.get("Guava");    // Moves Guava to the end
        linkedHashMap.get("Orange");   // Moves Orange to the end
        linkedHashMap.get("Orange");   // Orange already at the end, no change

        // Printing LinkedHashMap entries
        // Order reflects access-order: least recently used to most recently used
        System.out.println("LinkedHashMap (Access Order):");
        for (Map.Entry<String, Integer> fruits : linkedHashMap.entrySet()) {
            System.out.println(fruits.getKey() + ": " + fruits.getValue());
        }

        // Additional LinkedHashMap features
        // Check if a key exists
        System.out.println("\nContains key 'Apple': " + linkedHashMap.containsKey("Apple"));
        // Remove a key-value pair
        linkedHashMap.remove("Strawberry");
        System.out.println("After removing Strawberry: " + linkedHashMap);

        // === HashMap Demonstration ===
        // HashMap does not maintain any order of elements
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Adding key-value pairs to HashMap
        hashMap.put("Apple", 34);      // Adds Apple with value 34
        hashMap.put("Mango", 90);      // Adds Mango with value 90
        hashMap.put("Strawberry", 54); // Adds Strawberry with value 54

        // putIfAbsent: Adds a key-value pair only if the key is not present
        hashMap.putIfAbsent("Lemon", 78); // Adds Lemon since it's not present
        hashMap.putIfAbsent("Apple", 100); // Won't add, Apple already exists

        // getOrDefault: Returns value for the key, or a default value if key is absent
        Integer mango = hashMap.getOrDefault("Mango", 67); // Returns 90 (Mango's value)
        System.out.println("\nHashMap - Value of Mango: " + mango);

        Integer kiwi = hashMap.getOrDefault("Kiwi", -1); // Returns -1 (Kiwi not present)
        System.out.println("HashMap - Value of Kiwi: " + kiwi);

        // Printing HashMap entries
        // Order is not guaranteed (randomized based on hash)
        System.out.println("HashMap Entries:");
        for (Map.Entry<String, Integer> entries : hashMap.entrySet()) {
            System.out.println(entries.getValue() + ": " + entries.getKey());
        }

        // Additional HashMap features
        // Replace a value for a key
        hashMap.replace("Mango", 95); // Updates Mango's value to 95
        System.out.println("After replacing Mango's value: " + hashMap);

        // Compute a new value based on the existing one
        hashMap.computeIfPresent("Apple", (key, value) -> value + 10); // Apple: 34 -> 44
        System.out.println("After computing Apple + 10: " + hashMap);

        // Clear the HashMap
        hashMap.clear();
        System.out.println("HashMap after clearing: " + hashMap.isEmpty());
    }
}