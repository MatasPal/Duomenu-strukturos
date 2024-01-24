package utils;


import java.util.Iterator;
import java.util.stream.Collectors;

/*
Realizuokite visus interfeiso metodus susietojo sarašo pagrindu.
Nesinaudokite java klase LinkedList<E>, visa logika meginkite parasyti patys.
Jeigu reikia, galima kurti papildomus metodus ir kintamuosius.
*/
public class LinkedList<T> implements List<T> {
    private class Node {
        private T Data;
        public Node Link;

        public Node(T value, Node adress) {
            this.Data = value;
            this.Link = adress;
        }
    }

    private Node Head;
    private Node Tail;

    public LinkedList() {
        this.Head = null;
        Tail = null;
    }


    @Override
    public void add(T item) {
        Node newNode = new Node(item, null);
        if (this.Head == null) {
            this.Head = newNode;
            this.Tail = newNode;
        } else {
            this.Tail.Link = newNode;
            this.Tail = newNode;
        }
    }

    @Override
    public T get(int index) {
        int count = 0;
        for (Node a = Head; a != null; a = a.Link) {
            if (count == index) {
                return a.Data;
            }
            count++;
        }
        return null;
    }

    @Override
    public boolean remove(T item) {
        for (Node a = Head; a != null; a = a.Link) {
            if (a.Data.equals(item) && a != Head) {
                Node charge;
                for (charge = Head; charge.Link != a; charge = charge.Link) ;
                if (a == Tail) {
                    Tail = charge;
                    Tail.Link = null;
                } else {
                    charge.Link = a.Link;
                }
                return true;
            } else if (a.Data.equals(item) && a == Head) {
                Head = a.Link;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = Head;

            @Override
            public boolean hasNext() {
                if (current == null) {
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                Node temp;
                if (current != null) {
                    temp = current;
                } else {
                    temp = null;
                }
                current = current.Link;
                return temp.Data;
            }
        };
    }
}

