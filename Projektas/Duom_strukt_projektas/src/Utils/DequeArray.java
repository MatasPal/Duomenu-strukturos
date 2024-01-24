package Utils;

import java.util.NoSuchElementException;

//Deque Array class
public class DequeArray<E> implements Deque<E> {

    private Object[] elements;
    private int headIndex; //head index
    private int tailIndex; //tail index
    private int numberOfElements; //amount of elements

    public DequeArray(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be 1 or higher");
        }
        elements = new Object[capacity];
    }

    //Ensuring capacity
    private void ensureCapacity()
    {
        if (size() == elements.length)
        {
            Object[] ensuredArray = new Object[elements.length * 2];
            for (int i = 0; i < numberOfElements; i++)
            {
                ensuredArray[i] = elements[headIndex];
                headIndex = (headIndex + 1) % elements.length;
            }
            headIndex = 0;
            tailIndex = numberOfElements;
            elements = ensuredArray;
        }
    }

    //Adding element to the front
    @Override
    public void addFirst(E element) {
        ensureCapacity();

        headIndex = decreaseIndex(headIndex);
        elements[headIndex] = element;
        numberOfElements++;
    }

    //Returning first element
    @Override
    public E getFirst() {
        return elementAtHead();
    }

    //Removing first element
    @Override
    public E removeFirst() {
        E element = elementAtHead();
        elements[headIndex] = null;
        headIndex = increaseIndex(headIndex);
        numberOfElements--;
        return element;
    }

    //Adding element to the end
    @Override
    public void addLast(E element) {
        ensureCapacity();

        elements[tailIndex] = element;
        tailIndex = increaseIndex(tailIndex);
        numberOfElements++;
    }

    //Returning last element
    @Override
    public E getLast() {
        return elementAtTail();
    }

    //Removing last element
    @Override
    public E removeLast() {
        E element = elementAtTail();
        tailIndex = decreaseIndex(tailIndex);
        elements[tailIndex] = null;
        numberOfElements--;
        return element;
    }

    //Checking if array is empty
    @Override
    public boolean isEmpty() {
        return false;
    }
    private E elementAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[headIndex];
        return element;
    }

    private E elementAtTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[decreaseIndex(tailIndex)];
        return element;
    }

    private int decreaseIndex(int index) {
        index--;
        if (index < 0) {
            index = elements.length - 1;
        }
        return index;
    }

    private int increaseIndex(int index) {
        index++;
        if (index == elements.length) {
            index = 0;
        }
        return index;
    }

    //Size of an array
    public int size()
    {
        return numberOfElements;
    }

    //ToString method
    public String toString()
    {
        String dequeElements = "";


        for (int i = 0,j=0; j<elements.length;i=(i+1)% elements.length,j++)
        {

            if (elements[i]!=null)
                dequeElements = dequeElements + elements[i].toString()+ " ";
            else if (elements[j]!=null)
            {
                //System.out.println("j is: " +j);
                dequeElements = dequeElements + elements[j].toString()+ " ";
            }
        }
        return dequeElements;
    }
}

