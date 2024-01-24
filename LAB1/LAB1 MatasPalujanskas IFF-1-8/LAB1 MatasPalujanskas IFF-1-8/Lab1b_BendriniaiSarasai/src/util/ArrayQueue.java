package util;

import java.util.ArrayList;

public class ArrayQueue<E> implements Queue<E> {
    private ArrayList<E> list = new ArrayList();
    @Override
    public void enqueue(E item) {
        this.list.add(item);
    }

    @Override
    public E dequeue() {
        E holder = this.list.get(0);
        this.list.remove(0);
        return holder;
    }

    @Override
    public E peak() {
        return this.list.get(0);
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
