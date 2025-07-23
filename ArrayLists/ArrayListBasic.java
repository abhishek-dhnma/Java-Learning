package ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListBasic {
    public static void main(String[] args) {

        // Creating an ArrayList of Integers
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Adding elements to the list
        arrayList.add(2);
        arrayList.add(34);
        arrayList.add(26);
        arrayList.add(875);

        // Accessing elements by index
        System.out.println("Element at index 2 : " + arrayList.get(2));
        System.out.println("Element at index 3 : " + arrayList.get(3));

        // Getting size of the list
        System.out.println("Size : " + arrayList.size());

        // Iterating using traditional for loop
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Element at index " + i + ": " + arrayList.get(i));
        }

        // Iterating using enhanced for loop
        for (int x : arrayList) {
            System.out.println("For each: " + x);
        }

        // Checking if a value exists
        System.out.println(arrayList.contains(2));  // true
        System.out.println(arrayList.contains(23)); // false

        // Removing element at index 2
        arrayList.remove(2);
        System.out.println("After Remove at index 2");
        for (int x : arrayList) {
            System.out.println("For each: " + x);
        }

        // Adding an element at a specific index
        arrayList.add(2, 56);
        System.out.println("After adding at index 2");
        for (int x : arrayList) {
            System.out.println("For each: " + x);
        }

        // Replacing element at index 3
        arrayList.set(3, 567);
        System.out.println("After Setting at index 3 : 567");
        for (int x : arrayList) {
            System.out.println("For each: " + x);
        }

        // Different ways to create a list

        // Method 1: Creating an empty ArrayList using List interface
        List<String> list1 = new ArrayList<>();
        System.out.println("list1 type: " + list1.getClass().getName());

        // Method 2: Fixed-size list backed by array (cannot add/remove elements)
        List<String> list2 = Arrays.asList("Monday", "Tuesday");
        System.out.println("list2 type: " + list2.getClass().getName());
        list2.set(1, "Friday"); // OK to set values
        System.out.println("Modified list2: " + list2.get(1));

        // Method 3: Convert array to list
        String[] fruits = {"Apple", "Banana", "Cherry"};
        List<String> list3 = Arrays.asList(fruits);
        System.out.println("list3 type: " + list3.getClass().getName());

        // Convert fixed-size list to modifiable ArrayList
        List<String> newlist3 = new ArrayList<>(list3);
        newlist3.add("Guava");
        newlist3.add("Halwa");

        for (String s : newlist3) {
            System.out.println("Fruit: " + s);
        }

        // Method 4: Creating immutable list using List.of (Java 9+)
        List<Integer> list4 = List.of(2, 3, 44, 23, 43, 223);
        for (int e : list4) {
            System.out.println("List.of element: " + e);
        }

        // Removing specific value using Integer.valueOf to avoid index confusion
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2)); // removes value 2, not element at index 2
        System.out.println("List after removing 2: " + list);

        // Removing by value (first occurrence)
        List<String> name = new ArrayList<>();
        name.add("Sham");
        name.add("Gopi");
        name.add("Ram");
        name.add("Gopi"); // duplicate
        name.add("Abhi");

        name.remove("Gopi"); // removes first occurrence of "Gopi"
        System.out.println("Names after removing 'Gopi': " + name);

        // Sorting list alphabetically
        name.sort(null); // or use Collections.sort(name)
        System.out.println("After Sorting: " + name);

        // --------- Additional Useful Operations for Learning ---------

        // Checking if a list is empty
        System.out.println("Is list empty? " + name.isEmpty());

        // Finding the index of an element
        System.out.println("Index of 'Ram': " + name.indexOf("Ram"));

        // Last occurrence of an element
        System.out.println("Last index of 'Gopi': " + name.lastIndexOf("Gopi"));

        // Creating sublist (view only)
        List<String> sublist = name.subList(0, 2); // from index 0 to 1
        System.out.println("Sublist: " + sublist);

        // Cloning a list
        List<String> clonedList = new ArrayList<>(name);
        System.out.println("Cloned list: " + clonedList);

        // Clearing all elements
        clonedList.clear();
        System.out.println("After clearing cloned list: " + clonedList);

        // Sorting numbers in descending order
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 7));
        numbers.sort(Collections.reverseOrder());
        System.out.println("Numbers sorted in descending order: " + numbers);
    }
}
