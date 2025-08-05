package IdentityHashMap;

// Importing necessary Java utilities for HashMap, IdentityHashMap, and Map interface
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

    public static void main(String[] args) {
        // Create a standard HashMap, which uses equals() and hashCode() for key comparison
        // HashMap treats keys as equal if they have the same content (via equals())
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Create an IdentityHashMap, which uses reference equality (==) for key comparison
        // IdentityHashMap treats keys as equal only if they are the same object in memory
        // Behind the scenes: Uses System.identityHashCode() for hashing and linear probing for collision resolution
        // Key Comparison: Uses reference equality (==) instead of equals().
        //Hashing: Uses System.identityHashCode() for hash codes,
        // which is based on the object's memory address or a unique identifier assigned by the JVM
        Map<String, Integer> identityHashMap = new IdentityHashMap<>();

        // Create two distinct String objects with the same content
        // These are separate objects in memory, so k1 != k2, but k1.equals(k2) is true
        String k1 = new String("Key");
        String k2 = new String("Key");

        // Populate HashMap with the two keys
        // Since k1.equals(k2) is true, HashMap treats them as the same key
        // The second put overwrites the first, resulting in one entry
        hashMap.put(k1, 1);
        hashMap.put(k2, 2); // Overwrites k1's value because k1 and k2 are equal by content

        // Print HashMap contents
        // Expected: {Key=2}, as only one entry remains due to equals()-based comparison
        System.out.println("HashMap contents: " + hashMap);

        // Print hash codes to show k1 and k2 have the same hashCode()
        // String's hashCode() is content-based, so k1 and k2 have identical hash codes
        System.out.println("HashCode of k1: " + k1.hashCode());
        System.out.println("HashCode of k2: " + k2.hashCode());

        // Populate IdentityHashMap with the same keys
        // Since k1 != k2 (different object references), IdentityHashMap treats them as distinct keys
        // Behind the scenes: Uses reference equality (==) and System.identityHashCode() for key placement
        identityHashMap.put(k1, 1);
        identityHashMap.put(k2, 2); // Adds a separate entry, as k1 and k2 are different objects

        // Print system identity hash codes to show k1 and k2 are distinct objects
        // System.identityHashCode() returns a hash based on the object's reference (memory address or JVM-assigned ID)
        System.out.println("IdentityHashCode of k1: " + System.identityHashCode(k1));
        System.out.println("IdentityHashCode of k2: " + System.identityHashCode(k2));

        // Print IdentityHashMap contents
        // Expected: {Key=1, Key=2}, as k1 and k2 are treated as separate keys due to reference equality
        System.out.println("IdentityHashMap contents: " + identityHashMap);
    }
}