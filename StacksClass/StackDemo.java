package StacksClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();

        stk.push(5);
        stk.push(76);
        stk.push(87);
        stk.push(4);

        for(int e : stk){
            System.out.println(e);
        }

        System.out.println(stk);

        stk.pop();

        System.out.println(stk.peek());

        System.out.println(stk.isEmpty());
        System.out.println(stk.size());

        int search = stk.search(76);

        System.out.println(search);



        // linkedlist can be used as STACK

        System.out.println("LINKED LIST AS STACK");

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(2); // push
        linkedList.addLast(4); // push
        linkedList.addLast(7);
        linkedList.getLast(); // peek
        linkedList.removeLast(); // pop

        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());


        // ARRAY LIST AS STACK

        System.out.println("ARRAY LIST AS STACK");

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(2); // push
        arrayList.add(9); //push
        arrayList.add(16); //push

        System.out.println(arrayList);

        arrayList.get(arrayList.size() -1); // peek;
        arrayList.remove(arrayList.size() -1); // pop

        System.out.println(arrayList);


    }
}
