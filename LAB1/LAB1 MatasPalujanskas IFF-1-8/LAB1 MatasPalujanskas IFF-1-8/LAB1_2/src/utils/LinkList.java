package utils;


import models.Collector;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    @Override
    public Iterator iterator() {
        return new CustomIterator();
    }


    private class CustomIterator implements Iterator {
        Node current = Head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T data = current.Value;
                current = current.Link;
                return data;
            }
            else {
                return null;
            }
        }
    }
    class Node{
        T Value;
        Node Link;

        public Node(T value, Node link) {
            this.Value = value;
            this.Link = link;
        }
    }
    Node Head;
    Node Tail;
    Node current = Head;

    public void add(T item) {
        Node node = new Node(item, null);
        if (Head == null) {
            Head = node;
            Tail = node;
        }

        else {
            Tail.Link = node;
            Tail = node;
        }
    }


}
