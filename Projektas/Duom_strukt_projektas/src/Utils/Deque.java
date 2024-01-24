package Utils;

public interface Deque<E> {
    void addFirst(E e);
    E getFirst();
    E removeFirst();
    void addLast(E e);
    E getLast();
    E removeLast();
    boolean isEmpty();
}