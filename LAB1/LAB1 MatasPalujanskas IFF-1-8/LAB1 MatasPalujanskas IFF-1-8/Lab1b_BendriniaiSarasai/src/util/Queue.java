package util;

public interface Queue<E> {
    void enqueue(E item);

    E dequeue();

    E peak();

    boolean isEmpty();
    E dequeue(int index);
}
