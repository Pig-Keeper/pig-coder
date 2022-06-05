package geeksforgeeks.utils;

import java.util.Iterator;
import geeksforgeeks.interfaces.Pool;

public class NodePool<T> implements Pool<T> {
    private NodeWrapper head;
    private int size;
    private int maxNodes;

    public NodePool() {
        this(null, 0, -1);
    }

    public NodePool(int maxNodes) {
        this(null, 0, maxNodes);
    }

    private NodePool(NodeWrapper head, int size, int maxNodes) {
        this.head = head;
        this.size = size;
        this.maxNodes = maxNodes;
    }

    @Override
    public void add(T node) {
        add(node, size);
    }

    @Override
    public void add(T node, int index) {
        if(maxNodes != -1 && size == maxNodes) {
            System.err.println("NodeList.add : The maximum possible allowed nodes are " + maxNodes);
            System.err.println("NodeList.add : The List has reached maximum permissible nodes");
            System.err.println("NodeList.add : To add this node, first please remove some node(s)");
            return;
        }

        if(index > size) {
            System.err.println("NodeList.add : The provided index '" + index + "' is greater than childrens length");
            return;
        }

        NodeWrapper curr = head;
        NodeWrapper prev = null;
        int count = 0;

        while(curr != null && count != index) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if(prev == null) {
            head = new NodeWrapper(node, head);
        } else {
            prev.setNext(new NodeWrapper(node, curr));
        }

        size++;
    }

    @Override
    public void remove() {
        remove(size - 1);
    }

    @Override
    public void remove(int index) {
        if(index > size - 1) {
            System.err.println("NodePool.remove: The provided index '" + index + "' is greater than childrens length");
        }

        NodeWrapper curr = head;
        NodeWrapper prev = null;
        int count = 0;

        while(curr != null && count != index) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if(prev == null) {
            head = head.getNext();
        } else {
            prev.setNext(curr.getNext());
        }

        size--;
    }

    @Override
    public T get(int index) {
        if(index >= maxNodes) {
            System.err.println("NodePool.get: The provided index '" + index + "' is greater than max allowed nodes");
            return null;
        }

        if(index >= size) {
            return null;
        }

        NodeWrapper curr = head;
        int count = 0;

        while(curr != null && count != index) {
            curr = curr.getNext();
            count++;
        }
        return curr.getNode();
    }

    @Override
    public void update(T node, int index) {
        if(index >= maxNodes) {
            System.err.println("NodePool.update: The provided index '" + index + "' is greater than max allowed nodes");
            return;
        }

        if(index >= size) {
            this.add(node, index);
            return;
        }

        NodeWrapper curr = head;
        int count = 0;

        while(curr != null && count != index) {
            curr = curr.getNext();
            count++;
        }

        curr.setNode(node);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head = null;
        
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodeWrapper curr = head;

            @Override
            public boolean hasNext() {
                if(curr == null){
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                T node = curr.getNode();
                curr = curr.getNext();
                return node;
            }
            
        };
    }
    
    private class NodeWrapper {
        private NodeWrapper next;
        private T node;
    
        public NodeWrapper(T node, NodeWrapper next) {
            this.node = node;
            this.next = next;
        }
    
        public NodeWrapper getNext() {
            return this.next;
        }
    
        public T getNode() {
            return this.node;
        }

        public void setNext(NodeWrapper next) {
            this.next = next;
        }

        public void setNode(T child) {
            this.node = child;
        }
    }
}
