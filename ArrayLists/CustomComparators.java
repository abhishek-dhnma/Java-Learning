package ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Custom comparator class for integers (for descending order)
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // o1 = 5, o2 = 3
        // If result > 0 => o1 > o2 => o2 comes first => descending
        return o2 - o1; // Descending order
        // Alternative: Integer.compare(o2, o1)
    }
}

public class CustomComparators {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(4);
        values.add(123);
        values.add(809);
        values.add(40);

        System.out.println("Original: " + values);

        // Default sorting (ascending) using natural order
        values.sort(null); // same as Collections.sort(values);
        System.out.println("Sorted (Ascending): " + values);

        System.out.println("Sorted (Descending Order):");

        // ✅ Option 1: Using custom comparator class
        // values.sort(new MyComparator());

        // ✅ Option 2: Using lambda expression (more concise)
        values.sort((a, b) -> b - a); // Descending order
        // Alternatively: values.sort(Comparator.reverseOrder());
        // Or: values.sort((a, b) -> Integer.compare(b, a));

        System.out.println(values);

        List<String> words = Arrays.asList("words", "okie", "hi", "banana", "okh");
        System.out.println("Original: " + words);

        // ✅ Option 1: Using custom comparator class
        // words.sort(new MyWordComparator());

        // ✅ Option 2: Sort by string length in descending order using lambda
        words.sort((a, b) -> b.length() - a.length());
        // Alternatively: Comparator.comparingInt(String::length).reversed()

        System.out.println("After custom sorting by length (descending): " + words);


        values.sort(Comparator.reverseOrder()); // For descending integers

        words.sort(Comparator.comparing(String::length)); // Ascending by length

        words.sort(Comparator.comparing(String::length).reversed()); // Descending by length

    }

    // Custom comparator for sorting strings based on length
    private static class MyWordComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            // Ascending by length
            // return o1.length() - o2.length();

            // Descending by length
            return o2.length() - o1.length();

            // Alternatively: return Integer.compare(o2.length(), o1.length());
        }
    }
}
