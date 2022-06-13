/*
 * @Created on Sat Jun 11 2022 19:10:01
 * @ProblemLink https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Insert_into_a_Binary_Search_Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
            String value = sc.next();
            if(value.equals("null")) {
                list.add(null);
            } else {
                list.add(Integer.valueOf(value));
            }   
        }

        int insertVal = sc.nextInt();
        // assume BT is BST
        // @todo change to BST
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        (new Inner()).insertIntoBST(binaryTree.getRoot(), insertVal).printInorder();
        
        sc.close();
    }

    static class Inner {
        public BinaryTreeNode<Integer> insertIntoBST(BinaryTreeNode<Integer> root, int insertVal) {
            if(root == null) {
                root = new BinaryTreeNode<>(insertVal);
                return root;
            }

            if(root.getValue() > insertVal && root.getLeft() == null) {
                root.setLeft(new BinaryTreeNode<>(insertVal));
                return root;
            }

            if(root.getValue() < insertVal && root.getRight() == null) {
                root.setRight(new BinaryTreeNode<>(insertVal));
                return root;
            }

            if(insertVal > root.getValue()) {
                insertIntoBST(root.getRight(), insertVal);
            } else {
                insertIntoBST(root.getLeft(), insertVal);
            }
            return root;
        }
    }

    //Solution for Leetcode
    // public TreeNode insertIntoBST(TreeNode root, int insertVal) {
    //     if(root == null) {
    //         root = new TreeNode(insertVal);
    //         return root;
    //     }

    //     if(root.val > insertVal && root.left == null) {
    //         root.left = new TreeNode(insertVal);
    //         return root;
    //     }

    //     if(root.val < insertVal && root.right == null) {
    //         root.right = new TreeNode(insertVal);
    //         return root;
    //     }

    //     if(insertVal > root.val) {
    //         insertIntoBST(root.right, insertVal);
    //     } else {
    //         insertIntoBST(root.left, insertVal);
    //     }
        
    //     return root;
    // }
}
