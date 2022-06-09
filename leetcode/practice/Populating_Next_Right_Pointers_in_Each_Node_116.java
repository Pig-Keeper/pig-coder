/*
 * @Created on Mon Jun 06 2022 06:00:02
 * @ProblemLink https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTreeNodeWithNext;
import geeksforgeeks.binary_tree.BinaryTreeWithNext;

public class Populating_Next_Right_Pointers_in_Each_Node_116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        BinaryTreeWithNext<Integer> binaryTreeWithNext = new BinaryTreeWithNext<>(); 
        
        for(int i = 0; i < size; i++) {
            binaryTreeWithNext.insertByString(sc.next(), sc.nextInt());
        }

        binaryTreeWithNext.printPreorder();

        (new Inner()).connect(binaryTreeWithNext.getRoot());

        BinaryTreeNodeWithNext<Integer> temp = binaryTreeWithNext.getRoot();

        while(temp != null) {
            BinaryTreeNodeWithNext<Integer> curr = temp;
            while(curr != null) {
                System.out.print(curr.getValue() + " ");
                curr = curr.getNext();
            }
            temp = temp.getLeft();
        }

        sc.close();
    }

    static class Inner {
        public BinaryTreeNodeWithNext<Integer> connect(BinaryTreeNodeWithNext<Integer> root) {
            if(root == null || root.getLeft() == null || root.getRight() == null) {
                return root;
            }

            root.getLeft().setNext(root.getRight());

            if(root.getNext() != null) {
                root.getRight().setNext(root.getNext().getLeft());
            }

            connect(root.getLeft());
            connect(root.getRight());

            return root;
        } 
    }

    // Leetcode solution
    // public Node connect(Node root) {
    //     if(root == null || root.left == null || root.right == null) {
    //         return root;
    //     }

    //     root.left.next = root.right;
        
    //     if(root.next != null) {
    //         root.right.next = root.next.left;
    //     }
        
    //     connect(root.left);
    //     connect(root.right);;

    //     return root;
    // } 
}
