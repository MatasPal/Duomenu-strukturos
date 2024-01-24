package utils;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public Iterator<T> iterator() {
        return new Iterator<T>() {

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

                return null;
            }
        };
    }
    class Node{
        public T Value;
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
