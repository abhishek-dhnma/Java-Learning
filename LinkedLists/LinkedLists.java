package LinkedLists;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedLists {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("fw23");
        linkedList.add("fs3");
        linkedList.add("i8jdw");
        linkedList.add("9enX932");
        linkedList.addFirst("43d344");
        linkedList.addLast("8wh99");

        System.out.println(linkedList.getFirst());
        System.out.println("linkedList = " + linkedList.getLast());
        System.out.println("LinkedLists.main");
        System.out.println(linkedList);


        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Monkey", "Dog", "Lion", "Elephant"));
        LinkedList<String> animelToRemove = new LinkedList<>(Arrays.asList("Cat", "Lion"));

        animals.removeAll(animelToRemove);

        System.out.println(animals);

    }
}
