/*
 * @Created on Sat Jun 11 2022 18:55:21
 * @ProblemLink https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Search_in_a_Binary_Search_Tree_700 {
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

        int target = sc.nextInt();
        // assume BT is BST
        // @todo change to BST
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        BinaryTreeNode<Integer> node = (new Inner()).searchBST(binaryTree.getRoot(), target);

        if(node == null) {
            System.out.println("null");
        } else {
            node.printInorder();
        }

        sc.close();
    }

    static class Inner {
        public BinaryTreeNode<Integer> searchBST(BinaryTreeNode<Integer> root, int target) {
            if(root == null) {
                return root;
            }

            if(root.getValue() == target) {
                return root;
            }

            return target > root.getValue() ? searchBST(root.getRight(), target) : searchBST(root.getLeft(), target);
        }
    }

    //Solution for Leetcode
    // public TreeNode searchBST(TreeNode root, int target) {
    //     if(root == null) {
    //         return root;
    //     }

    //     if(root.val == target) {
    //         return root;
    //     }

    //     return target > root.val ? searchBST(root.right, target) : searchBST(root.left, target);
    // }
}
