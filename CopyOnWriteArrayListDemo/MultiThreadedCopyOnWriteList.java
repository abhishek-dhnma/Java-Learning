package CopyOnWriteArrayListDemo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiThreadedCopyOnWriteList {

    public static void main(String[] args) {

        List<String> shoppingList = new CopyOnWriteArrayList<>();

        shoppingList.add("Egg");
        shoppingList.add("Milk");
        shoppingList.add("Bread");

        // Multiple Reader Threads
        for (int i = 1; i <= 3; i++) {
            final int readerId = i;
            new Thread(() -> {
                for (String item : shoppingList) {
                    System.out.println("👀 Reader-" + readerId + " reads: " + item);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // Multiple Writer Threads
        for (int i = 1; i <= 2; i++) {
            final int writerId = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200); // Let readers begin first
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String newItem = "Item-" + writerId;
                System.out.println("✍️ Writer-" + writerId + " adds: " + newItem);
                shoppingList.add(newItem);
            }).start();
        }

        // Allow all threads to finish (main thread sleeps)
        try {
            Thread.sleep(1500);  // Adjust time based on processor speed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Final Shopping List: " + shoppingList);
    }
}
