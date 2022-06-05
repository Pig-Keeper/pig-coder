/*
 * @Created on Fri Jun 03 2022 03:04:42
 * @ProblemLink https://www.geeksforgeeks.org/data-structures/linked-list/#singlyLinkedList
 *
 * @Author Pig Keeper
 */

package geeksforgeeks.singly_linked_list;

import geeksforgeeks.abstracts.AbstractNode;

public class SinglyLinkedListNode<T> extends AbstractNode<T> {

    public SinglyLinkedListNode() {
        this(null);
    }

    public SinglyLinkedListNode(T value) {
        this(value, null);
    }

    public SinglyLinkedListNode(T value, SinglyLinkedListNode<T> next) {
        super(value, 1);
        this.pool.add(next, 0);
    }

    public SinglyLinkedListNode<T> getNext() {
        return (SinglyLinkedListNode<T>)this.pool.get(0);
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.pool.update(next, 0);
    }

    public void printDeep() {
        this.print();
        if(this.getNext() != null) {
            System.out.print(" ");
            this.getNext().printDeep();;
        }
    }
}
