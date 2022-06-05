package geeksforgeeks.abstracts;

import geeksforgeeks.interfaces.Pool;
import geeksforgeeks.utils.NodePool;

public abstract class AbstractNode<T> {
    protected T value;
    protected Pool<AbstractNode<T>> pool;
    
    public AbstractNode() {
        this(null, -1);
    }

    public AbstractNode(T value) {
        this(value, -1);
    }

    public AbstractNode(int maxChild) {
        this(null, new NodePool<AbstractNode<T>>(maxChild));
    }

    public AbstractNode(T value, int maxChild) {
        this(value, new NodePool<AbstractNode<T>>(maxChild));
    }

    public AbstractNode(T value, Pool<AbstractNode<T>> pool) {
        this.value = value;
        this.pool = pool;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print() {
        System.out.print(this.value);
    }

    public void println() {
        System.out.println(this.value);
    }

    public abstract void printDeep();
}
