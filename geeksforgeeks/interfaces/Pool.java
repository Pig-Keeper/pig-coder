package geeksforgeeks.interfaces;

public interface Pool<T> extends Iterable<T> {
    void add(T item);
    
    void add(T item, int index);

    void remove(int index);

    void remove();

    T get(int index);

    void update(T item, int index);

    int size();

    void clear();
}
