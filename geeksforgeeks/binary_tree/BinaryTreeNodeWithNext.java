/*
 * @Created on Sun Jun 05 2022 17:34:14
 * @ProblemLink https://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 * @Author Pig Keeper
 */

package geeksforgeeks.binary_tree;

import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class BinaryTreeNodeWithNext<T> extends BinaryTreeNode<T> {
    private SinglyLinkedListNode<BinaryTreeNode<T>> listNode;

    public BinaryTreeNodeWithNext() {
        this(null);
    }

    public BinaryTreeNodeWithNext(T value) {
        this(value, null, null);
    }

    public BinaryTreeNodeWithNext(T value, BinaryTreeNodeWithNext<T> left, BinaryTreeNodeWithNext<T> right) {
        this(value, left, right, null);
    }

    public BinaryTreeNodeWithNext(T value, BinaryTreeNodeWithNext<T> left, BinaryTreeNodeWithNext<T> right, BinaryTreeNodeWithNext<T> next) {
        super(value, left, right);
        listNode = new SinglyLinkedListNode<>(next);
    }

    public BinaryTreeNodeWithNext<T> getLeft() {
        return (BinaryTreeNodeWithNext<T>)super.getLeft();
    }

    public void setLeft(BinaryTreeNodeWithNext<T> left) {
        super.setLeft(left);
    }
    
    public BinaryTreeNodeWithNext<T> getRight() {
        return (BinaryTreeNodeWithNext<T>)super.getRight();
    }

    public void setRight(BinaryTreeNodeWithNext<T> right) {
        super.setRight(right);
    }

    public BinaryTreeNodeWithNext<T> getNext() {
        return (BinaryTreeNodeWithNext<T>)this.listNode.getValue();
    }

    public void setNext(BinaryTreeNodeWithNext<T> next) {
        this.listNode.setValue(next);
    }
}
