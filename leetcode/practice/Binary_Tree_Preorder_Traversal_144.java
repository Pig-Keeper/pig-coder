/*
 * @Created on Wed Jun 08 2022 16:59:01
 * @ProblemLink https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Binary_Tree_Preorder_Traversal_144 {
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

        binaryTree.printPreorder();

        System.out.println((new Inner()).preorderTraversal(binaryTree.getRoot()));
        sc.close();
    }

    static class Inner {
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
            if(root == null) {
                return list;
            }

            list.add(root.getValue());
            preorderTraversal(root.getLeft());
            preorderTraversal(root.getRight());
            
            return list;
        }

        // Leetcode solution
        // public List<Integer> preorderTraversal(TreeNode root) {
        //     if(root == null) {
        //         return list;
        //     }

        //     list.add(root.val);
        //     preorderTraversal(root.left);
        //     preorderTraversal(root.right);
            
        //     return list;
        // }
    }
}
