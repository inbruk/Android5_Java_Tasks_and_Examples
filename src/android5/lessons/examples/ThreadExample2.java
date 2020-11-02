package android5.lessons.examples;

import java.util.*;

public class ThreadExample2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            numbers.add(i);
        }
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Max found: " + max);

        List<Integer> unsorted = new ArrayList<>();
        for (int i = 10000000; i >= 1; i--) {
            unsorted.add(i);
        }
        Collections.sort(unsorted);
        System.out.println("List sorted");

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            list.add(i);
        }
        while (list.size() != 0) {
            list.remove(list.size() - 1);
        }
        System.out.println("List cleared");

        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms");
    }

}
