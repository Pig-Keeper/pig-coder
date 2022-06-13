/*
 * @Created on Sat Jun 11 2022 18:55:21
 * @ProblemLink https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Validate_Binary_Search_Tree_98 {
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

        // assume BT is BST
        // @todo change to BST
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        System.out.println((new Inner()).isValidBST(binaryTree.getRoot()));

        sc.close();
    }

    static class Inner {
        public boolean isValidBST(BinaryTreeNode<Integer> root) {
            if(root == null) {
                return true;
            }

            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }


        private boolean isValidBST(BinaryTreeNode<Integer> root, int leftRange, int rightRange) {
            if(root == null) {
                return true;
            }

            if(root.getValue() == Integer.MIN_VALUE && root.getLeft() != null) {
                return false;
            }

            if(root.getValue() == Integer.MAX_VALUE && root.getRight() != null) {
                return false;
            }

            return root.getValue() >= leftRange && 
                root.getValue() <= rightRange && 
                isValidBST(root.getLeft(), leftRange, root.getValue() - 1) &&
                isValidBST(root.getRight(), root.getValue() + 1, rightRange);
        }
    }
}