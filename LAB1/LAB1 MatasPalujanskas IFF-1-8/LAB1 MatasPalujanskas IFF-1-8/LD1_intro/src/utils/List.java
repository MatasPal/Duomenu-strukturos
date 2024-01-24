package utils;

public interface List<T> extends Iterable<T>{
    // add item to the end
    public void add(T item);
    // get element by its place in list
    public T get(int index);
    // remove item, if item removed return true, else return false
    public boolean remove(T item);
}
