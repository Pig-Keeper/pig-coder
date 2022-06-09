/*
 * @Created on Sun Jun 05 2022 17:34:14
 * @ProblemLink https://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 * @Author Pig Keeper
 */

package geeksforgeeks.binary_tree;

import geeksforgeeks.abstracts.AbstractNode;

public class BinaryTreeNode<T> extends AbstractNode<T> {

    public BinaryTreeNode() {
        this(null);
    }

    public BinaryTreeNode(T value) {
        this(value, null, null);
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        super(value, 2);
        this.pool.add(left, 0);
        this.pool.add(right, 1);
    }

    public BinaryTreeNode<T> getLeft() {
        return (BinaryTreeNode<T>)this.pool.get(0);
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.pool.update(left, 0);
    }
    
    public BinaryTreeNode<T> getRight() {
        return (BinaryTreeNode<T>)this.pool.get(1);
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.pool.update(right, 1);
    }

    public void printInorder() {
        if(this.getLeft() != null) {
            this.getLeft().printInorder();
        }

        System.out.print(this.toString() + " ");

        if(this.getRight() != null) {
            this.getRight().printInorder();
        }
    }

    public void printPreorder() {
        System.out.print(this.toString() + " ");
        
        if(this.getLeft() != null) {
            this.getLeft().printPreorder();
        }

        if(this.getRight() != null) {
            this.getRight().printPreorder();
        }
    }

    public void printPostorder() {
        if(this.getLeft() != null) {
            this.getLeft().printPostorder();
        }
        
        if(this.getRight() != null) {
            this.getRight().printPostorder();
        }

        System.out.print(this.toString() + " ");
    }
}
