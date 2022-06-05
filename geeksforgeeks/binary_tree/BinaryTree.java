/*
 * @Created on Sun Jun 05 2022 17:34:14
 * @ProblemLink https://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 * @Author Pig Keeper
 */
package geeksforgeeks.binary_tree;

import java.util.Stack;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        this. root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    public BinaryTree<T> insertLeftMost(T value) {
        if(root == null) {
            root = new BinaryTreeNode<T>(value);
            return this;
        }

        BinaryTreeNode<T> temp = root;
        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }

        temp.setLeft(new BinaryTreeNode<T>(value));
        return this;
    }

    public BinaryTree<T> insertRightMost(T value) {
        if(root == null) {
            root = new BinaryTreeNode<T>(value);
            return this;
        }

        BinaryTreeNode<T> temp = root;
        while(temp.getRight() != null) {
            temp = temp.getRight();
        }

        temp.setRight(new BinaryTreeNode<T>(value));
        return this;
    }

    public BinaryTree<T> insertAtFirstEmpty(T value) {
        if(root == null) {
            root = new BinaryTreeNode<T>(value);
            return this;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while(stack != null) {
            BinaryTreeNode<T> temp = stack.pop();
            if(temp.getLeft() == null) {
                temp.setLeft(new BinaryTreeNode<T>(value));
                return this;
            } else {
                stack.push(temp.getLeft());
            }

            if(temp.getRight() == null) {
                temp.setRight(new BinaryTreeNode<T>(value));
                return this;
            } else {
                stack.push(temp.getRight());
            }
        }

        return this;
    }

    public BinaryTree<T> insertByString(String str, T value) {
        str = str.toLowerCase().trim();
        
        if(root == null && str.equals("t")) {
            root = new BinaryTreeNode<T>(value);
            return this;
        }

        root = insertByString(root, str, value, 0);
        return this;
    }

    private BinaryTreeNode<T> insertByString(BinaryTreeNode<T> root, String str, T value, int index) {
        if(index == str.length() && root == null) {
            return new BinaryTreeNode<T>(value);
        }

        if(index == str.length()) {
            System.err.println("BinaryTree.insertByString: The node already exists at provided string '" + str + "' traversal");
            return root;  
        }

        if(root == null) {
            System.err.println("BinaryTree.insertByString: The provided string '" + str + "' traversal is invalid");
            return root;  
        }

        if(str.charAt(index) == 'l') {
            root.setLeft(insertByString(root.getLeft(), str, value, index + 1));
        } else if(str.charAt(index) == 'r') {
            root.setRight(insertByString(root.getRight(), str, value, index + 1));
        } else {
            System.err.println("BinaryTree.insertByString The provided string '" + str + "' contains invalid character");  
        }

        return root;
    }

    public BinaryTree<T> printInorder() {
        return this.printInorder("");
    }

    public BinaryTree<T> printInorder(String msg) {
        if(!msg.isBlank()) {
            System.out.println(msg);
        }

        if(root == null) {
            System.out.println("");
            return this;
        }

        root.printInorder();
        System.out.println("");

        return this;
    }

    public BinaryTree<T> printPreorder() {
        return this.printPreorder("");
    }

    public BinaryTree<T> printPreorder(String msg) {
        if(!msg.isBlank()) {
            System.out.println(msg);
        }

        if(root == null) {
            System.out.print("");
            return this;
        }

        root.printPreorder();
        System.out.println("");

        return this;
    }

    public BinaryTree<T> printPostorder() {
        return this.printPostorder("");
    }

    public BinaryTree<T> printPostorder(String msg) {
        if(!msg.isBlank()) {
            System.out.println(msg);
        }

        if(root == null) {
            System.out.println("");
            return this;
        }

        root.printPostorder();
        System.out.println("");

        return this;
    }
}
