package JavaLessons.Task521;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {
            java.util.Deque deque = new ArrayDeque();
            deque.offer(12);
            deque.add(6);
            deque.add(4);
            deque.poll();
            deque.peek();
        System.out.println(deque.element());
    }

}
