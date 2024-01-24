package util;

import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E>{
    java.util.LinkedList<E> list = new LinkedList();

    public LinkedListStack() {
    }
    @Override
    public E pop() {
        if (!this.list.isEmpty()) {
            E holder = this.list.getFirst();
            this.list.removeFirst();
            return holder;
        } else {
            return null;
        }
    }

    @Override
    public void push(E item) {this.list.addFirst(item);}

    @Override
    public E peak() {
        return !this.list.isEmpty() ? this.list.getFirst() : null;
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
