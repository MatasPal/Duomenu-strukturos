package Tests;

import Utils.DequeArray;
import Utils.DequeLinkedList;

import java.util.Locale;

public class ManualTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus
        //linkedListTests();
        arrayTests();

    }

    public static void linkedListTests()
    {
        DequeLinkedList<Integer> deque = new DequeLinkedList<>();

        System.out.println("Linked List Tests:\n");
        System.out.println(deque);
        deque.addFirst(1);
        System.out.println(deque);
        System.out.println("getFirst(): "+deque.getFirst());
        deque.addFirst(2);
        System.out.println(deque);
        System.out.println("getFirst(): "+deque.getFirst());
        deque.addFirst(3);
        System.out.println(deque);
        System.out.println("getFirst(): "+deque.getFirst());
        System.out.println("getLast(): "+deque.getLast());

        System.out.println("removeFirst(): "+deque.removeFirst());
        System.out.println(deque);
        System.out.println("getFirst(): "+deque.getFirst());

        deque.addLast(4);
        System.out.println(deque);
        System.out.println("getLast(): " +deque.getLast());

        System.out.println("removeLast(): "+deque.removeLast());
        System.out.println(deque);
        System.out.println("getLast(): "+deque.getLast());

    }

    public static void arrayTests()
    {
        DequeArray<Integer> deque = new DequeArray<>(3);

        System.out.println("Array Tests:\n");
        System.out.println(deque);
        deque.addFirst(1);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        deque.addFirst(2);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        deque.addLast(3);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());

        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());

        deque.addLast(4);
        System.out.println(deque);
        System.out.println("getLast(): " + deque.getLast());

        System.out.println("removeLast(): " + deque.removeLast());
        System.out.println(deque);
        System.out.println("getLast(): " + deque.getLast());

        deque.addLast(6);
        System.out.println(deque);
        System.out.println(deque.size());

        deque.addLast(7);
        System.out.println(deque);
        System.out.println(deque.size());

        deque.addFirst(9);
        System.out.println(deque);
        System.out.println("Array size:");
        System.out.println(deque.size());



    }
}

