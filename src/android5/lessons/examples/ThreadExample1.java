package android5.lessons.examples;

import java.util.*;

public class ThreadExample1 {

    public static void main(String[] args) throws InterruptedException {
        Thread maxFromList = new Thread(() -> {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 10000000; i++) {
                numbers.add(i);
            }
            Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
            System.out.println("Max found: " + max);
        });

        Thread sortedList = new Thread(() -> {
            List<Integer> unsorted = new ArrayList<>();
            for (int i = 10000000; i >= 1; i--) {
                unsorted.add(i);
            }
            Collections.sort(unsorted);
            System.out.println("List sorted");
        });

        Thread removeFirst = new Thread(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 10000000; i++) {
                list.add(i);
            }
            while (list.size() != 0) {
                list.remove(list.size() - 1);
            }
            System.out.println("List cleared");
        });

        long start = System.currentTimeMillis();
        maxFromList.start();
        sortedList.start();
        removeFirst.start();

        maxFromList.join();
        sortedList.join();
        removeFirst.join();

        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms");
    }

}
