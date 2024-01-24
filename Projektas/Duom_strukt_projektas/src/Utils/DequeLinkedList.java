package Utils;

import java.util.NoSuchElementException;

//Deque LinkedList class
public class DequeLinkedList<E> implements Deque<E> {

    private Node<E> head;   // Link to the first element
    private Node<E> tail;   // Link to the last element
    private int size = 0;   // Size

    public DequeLinkedList()
    {
        tail = null;
        head = null;
    }

    //Adding element to front
    @Override
    public void addFirst(E elementToAdd) {
        if (elementToAdd == null) throw new IllegalArgumentException();

        Node<E> node = new Node<>(null, elementToAdd, null);
        if (head == null) {
            head  = node;
            tail = head;
        }
        else
        {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    //Returning first element
    @Override
    public E getFirst() {
        if (this.head == null)
        {
            return null;
        }
        return this.head.value;
    }

    //Removing first element
    @Override
    public E removeFirst() {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        Node<E> toReturn = head;
        head = head.next;
        size--;
        return toReturn.value;
    }

    //Adding element to the end
    @Override
    public void addLast(E elementToAdd) {
        if (elementToAdd == null) throw new IllegalArgumentException();

        Node<E> node = new Node<>(null, elementToAdd, null);
        node.value = elementToAdd;

        if (head == null)
        {
            tail = node;
            head = tail;
        }
        else
        {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    //Returning last element
    @Override
    public E getLast() {
        if (this.tail == null)
        {
            return null;
        }
        return this.tail.value;
    }

    //Removing last element
    @Override
    public E removeLast() {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        Node<E> toReturn = tail;
        tail = tail.previous;
        tail.next = null;
        size--;
        return toReturn.value;
    }

    //Checking if list is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Node class
    private static class Node<E> {
        private E value;
        private Node<E> previous;
        private Node<E> next;

        private Node(Node<E> previous, E current, Node<E> next) {
            this.value = current;
            this.previous = previous;
            this.next = next;
        }
    }
    public int size()
    {
        return this.size;
    }
    public String toString()
    {
        StringBuilder deque = new StringBuilder();

        if (isEmpty())
        {
            deque.append("Deque is empty.");
            return deque.toString();
        }

        Node<E> first = head;
        deque.append("Deque elements: [ ").append(first.value).append(" ");
        while (first.next != null)
        {
            deque.append(first.next.value).append(" ");
            first = first.next;
        }
        deque.append("]");

        return deque.toString();
    }
}

