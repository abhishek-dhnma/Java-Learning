package VectorClass;

import com.sun.jdi.VMCannotBeModifiedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>(5,3);

        vec.add(2);

        System.out.println(vec.capacity());

        vec.add(3);
        vec.add(45);

        System.out.println(vec);

        ArrayList<Integer> arrayList = new ArrayList<>( Arrays.asList(2,45,2,5,2,113));
        Vector<Integer> vec1 = new Vector<>(arrayList);
        System.out.println(vec1);

        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vec2 = new Vector<>(linkedList);
        System.out.println(vec2);

        Vector<Integer> vec3 = new Vector<>(Arrays.asList(2,4,6,3,6,3,6,64,3,3,32));
        System.out.println(vec3);





    }
}
