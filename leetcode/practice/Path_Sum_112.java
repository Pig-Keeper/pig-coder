/*
 * @Created on Fri Jun 10 2022 15:59:59
 * @ProblemLink https://leetcode.com/problems/path-sum/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Path_Sum_112 {
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

        int targetSum = sc.nextInt();
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        System.out.println((new Inner()).hasPathSum(binaryTree.getRoot(), targetSum));

        sc.close();
    }

    static class Inner {
        public boolean hasPathSum(BinaryTreeNode<Integer> root, int targetSum) {
            if(root == null) {
                return false;
            }

            if(root != null && root.getLeft() == null && root.getRight() == null && targetSum == root.getValue()) {
                return true;
            }

            return hasPathSum(root.getLeft(), targetSum - root.getValue()) || hasPathSum(root.getRight(), targetSum - root.getValue());
        }
    }

    //Solution for Leetcode
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     if(root == null) {
    //         return false;
    //     }

    //     if(root != null && root.left == null && root.right == null && targetSum == root.val) {
    //         return true;
    //     }

    //     return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    // }
}
