package CopyOnWriteArrayListDemo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

        public static void main(String[] args) {

            List<String> shoppingList = new CopyOnWriteArrayList<>();

//            CopyOnWriteArrayList is a thread-safe variant of ArrayList. It is used when you have:
//
//            More read operations than write,
//
//                    And need safe iteration even when the collection is being modified concurrently.
//
//                    Internally, it works by creating a new copy of the array every time you write
//                     (add/remove/update) — so readers can iterate over the old, consistent snapshot.



                    shoppingList.add("Egg");
            shoppingList.add("Milk");
            shoppingList.add("Bread");

            // Thread 1: Reader
            Thread readerThread = new Thread(() -> {
                for (String item : shoppingList) {
                    System.out.println("Reader Thread: " + item);
                    try {
                        Thread.sleep(100); // Simulate some delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Thread 2: Writer
            Thread writerThread = new Thread(() -> {
                try {
                    Thread.sleep(150); // Delay so reader starts first
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Writer Thread: Adding 'Butter'");
                shoppingList.add("Butter");

                System.out.println("Writer Thread: Adding 'Juice'");
                shoppingList.add("Juice");
            });

            readerThread.start();
            writerThread.start();

            try {
                readerThread.join();
                writerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final Shopping List: " + shoppingList);


    }
}
