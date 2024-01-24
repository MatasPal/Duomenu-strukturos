package util;

import java.util.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {
    java.util.LinkedList<E> list = new LinkedList();

    public LinkedListQueue() {
    }
    @Override
    public void enqueue(E item) {
        this.list.addLast(item);
    }

    @Override
    public E dequeue() {
        E holder = this.list.getFirst();
        this.list.removeFirst();
        return holder;
    }

    @Override
    public E peak() {
        return this.list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public E dequeue(int index) {
        if(index < 0 || index > this.list.size()) new IndexOutOfBoundsException("Index out of bounds!");
        E holder = this.list.get(index);
        this.list.remove(index);
        return holder;
    }
}
