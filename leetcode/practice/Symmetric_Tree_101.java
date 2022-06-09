/*
 * @Created on Wed Jun 08 2022 17:42:24
 * @ProblemLink `Enter Problem Link here`
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Symmetric_Tree_101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();

        BinaryTree<Integer> binaryTree1 = new BinaryTree<>();

        for(int i = 0; i < size1; i++) {
            binaryTree1.insertByString(sc.next(), sc.nextInt());
        }

        binaryTree1.printInorder();

        System.out.println((new Inner()).isSymmetric(binaryTree1.getRoot()));
        sc.close();
    }

    static class Inner {
        public boolean isSymmetric(BinaryTreeNode<Integer> root) {
            if(root == null) {
                return true;
            }

            return isSymmetric(root.getLeft(), root.getRight());
        }

        private boolean isSymmetric(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
            if(left == null && right == null) {
                return true;
            }

            if(left == null || right == null) {
                return false;
            }

            return left.getValue() == right.getValue() && 
                isSymmetric(left.getLeft(), right.getRight()) &&
                    isSymmetric(left.getRight(), right.getLeft());
        }

        // Leetcode solution
        // public boolean isSymmetric(TreeNode root) {
        //     if(root == null) {
        //         return true;
        //     }
    
        //     return isSymmetric(root.left, root.right);
        // }
    
        // private boolean isSymmetric(TreeNode left, TreeNode right) {
        //     if(left == null && right == null) {
        //         return true;
        //     }
    
        //     if(left == null || right == null) {
        //         return false;
        //     }
            
        //     return left.val == right.val && 
        //         isSymmetric(left.left, right.right) &&
        //             isSymmetric(left.right, right.left);
        // }
    }
}
