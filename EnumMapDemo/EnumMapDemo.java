package EnumMapDemo;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        // Create an EnumMap with Days enum as key type and String as value type.
        // - EnumMap: Specialized Map for enum keys, uses an array internally for O(1) access.
        // - Constructor requires the enum class (Days.class) to initialize the array size (7 for Days).
        // - Keys must be from the Days enum; null keys throw NullPointerException, null values allowed.
        // - Maintains natural order of enum constants (MONDAY, TUESDAY, ..., SUNDAY).
        Map<Days, String> map = new EnumMap<>(Days.class);

//        Internal Working of EnumMap:
//
//        EnumMap creates an array of size equal to the number of enum constants (7 for Days).
//        Each key’s ordinal() value (e.g., THURSDAY.ordinal() == 3) determines the array index where its value is stored.
//                No hashing or collision handling is needed, unlike HashMap or ConcurrentHashMap, making operations consistently O(1).
//                Iteration follows the enum’s declaration order, ensuring predictable output.

        // Insert key-value pairs into the EnumMap.
        // - put(): Maps an enum key to a value in O(1) time by storing in the array at key.ordinal().
        // - Days enum constants are used as keys, with String activities as values.
        map.put(Days.MONDAY, "Work");     // Maps MONDAY (ordinal 0) to "Work".
        map.put(Days.THURSDAY, "Cycling"); // Maps THURSDAY (ordinal 3) to "Cycling".
        map.put(Days.FRIDAY, "Chill");    // Maps FRIDAY (ordinal 4) to "Chill".

        System.out.println(Days.THURSDAY.ordinal());

        // Print the EnumMap.
        // - Output: {MONDAY=Work, THURSDAY=Cycling, FRIDAY=Chill}
        // - Order is guaranteed to match enum declaration (MONDAY, TUESDAY, ..., SUNDAY).
        // - Only entries with non-null values are shown; unused enum constants (e.g., TUESDAY) are omitted.
        System.out.println("EnumMap contents: " + map);
    }
}

// Enum definition for Days, used as keys in the EnumMap.
// - Enum constants are implicitly assigned ordinal values: MONDAY=0, TUESDAY=1, ..., SUNDAY=6.
// - EnumMap uses these ordinals as array indices for efficient storage and retrieval.
enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}