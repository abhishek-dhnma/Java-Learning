package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Alice", 2);
        hashMap.put("Bob", 4);
        hashMap.put("Mary", 53);

        System.out.println(hashMap);
        Integer val = hashMap.get("Bob");
        System.out.println(val);

        boolean b = hashMap.containsKey("Alice");
        System.out.println(b);
        boolean b1 = hashMap.containsValue(53);
        System.out.println(b1);


        System.out.println("Loop Approach 1 : keySet()");
        Set<String> keys = hashMap.keySet();

        for(String i : keys){
            System.out.println(hashMap.get(i));
        }

        System.out.println("Loop Approach 2 : entrySet()");

        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();

        for(Map.Entry<String, Integer> entry : entries){

            System.out.println(entry.getKey().toUpperCase() + " : " + entry.getValue());
            entry.setValue(entry.getValue()-1);
        }

        System.out.println(hashMap);


    }
}
