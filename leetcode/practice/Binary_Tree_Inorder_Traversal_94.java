/*
 * @Created on Wed Jun 08 2022 17:09:22
 * @ProblemLink https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Binary_Tree_Inorder_Traversal_94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();

        BinaryTree<Integer> binaryTree1 = new BinaryTree<>();

        for(int i = 0; i < size1; i++) {
            binaryTree1.insertByString(sc.next(), sc.nextInt());
        }

        binaryTree1.printInorder();

        System.out.println((new Inner()).inorderTraversal(binaryTree1.getRoot()));
        sc.close();
    }

    static class Inner {
        private List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {
            if(root == null) {
                return list;
            }

            inorderTraversal(root.getLeft());
            list.add(root.getValue());
            inorderTraversal(root.getRight());
            
            return list;
        }

        // Leetcode solution
        // public List<Integer> inorderTraversal(TreeNode root) {
        //         if(root == null) {
        //             return list;
        //         }
    
        //         inorderTraversal(root.left);
        //         list.add(root.val);
        //         inorderTraversal(root.right);
                
        //         return list;
        // }
    }
}
