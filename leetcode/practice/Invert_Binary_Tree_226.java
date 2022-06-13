/*
 * @Created on Fri Jun 10 2022 15:46:50
 * @ProblemLink https://leetcode.com/problems/invert-binary-tree/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Invert_Binary_Tree_226 {
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

        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        (new Inner()).invertTree(binaryTree.getRoot()).printInorder();

        sc.close();
    }

    static class Inner {
        public <T> BinaryTreeNode<T> invertTree(BinaryTreeNode<T> root) {
            if(root == null) {
                return root;
            }

            invertTree(root.getLeft());
            invertTree(root.getRight());

            BinaryTreeNode<T> temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);

            return root;
        }

        // Solution to Leetcode
        // public TreeNode invertTree(TreeNode root) {
        //     if(root == null) {
        //         return root;
        //     }

        //     invertTree(root.left);
        //     invertTree(root.right);

        //     TreeNode temp = root.left;
        //     root.left = root.right;
        //     root.right = temp;

        //     return root;
        // }
    }
}
