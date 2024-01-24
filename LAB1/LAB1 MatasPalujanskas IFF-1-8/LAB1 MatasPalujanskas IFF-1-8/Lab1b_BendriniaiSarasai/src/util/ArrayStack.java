package util;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> stack = new ArrayList();
    private int lastIndex = -1;
    public ArrayStack(){
    }

    @Override
    public E pop() {
        if(this.lastIndex >= 0){
            E holder = this.stack.get(this.lastIndex);
            this.stack.remove(this.lastIndex);
            this.lastIndex --;
            return holder;
        }
        else{
            return null;
        }
    }

    @Override
    public void push(E item) {
        this.stack.add(item);
        this.lastIndex++;
    }

    @Override
    public E peak() {
        return this.lastIndex >= 0 ? this.stack.get(this.lastIndex) : null;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.size() == 0;
    }
}
