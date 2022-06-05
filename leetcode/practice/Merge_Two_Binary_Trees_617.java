/*
 * @Created on Sun Jun 05 2022 18:53:45
 * @ProblemLink https://leetcode.com/problems/merge-two-binary-trees/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Merge_Two_Binary_Trees_617 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();

        BinaryTree<Integer> binaryTree1 = new BinaryTree<>();

        for(int i = 0; i < size1; i++) {
            binaryTree1.insertByString(sc.next(), sc.nextInt());
        }

        int size2 = sc.nextInt();

        BinaryTree<Integer> binaryTree2 = new BinaryTree<>();

        for(int i = 0; i < size2; i++) {
            binaryTree2.insertByString(sc.next(), sc.nextInt());
        }

        (new Inner()).mergeTrees(binaryTree1.getRoot(), binaryTree2.getRoot()).printPreorder();
        sc.close();
    }
    
    static class Inner {
        public BinaryTreeNode<Integer> mergeTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
            if(root1 == null) {
                return root2;
            }

            if(root2 == null) {
                return root1;
            }

            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(root1.getValue() + root2.getValue());

            newRoot.setLeft(mergeTrees(root1.getLeft(), root2.getLeft()));

            newRoot.setRight(mergeTrees(root1.getRight(), root2.getRight()));

            return newRoot;
        }

        // Leetcode solution
        // public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //     if(root1 == null) {
        //         return root2;
        //     }
    
        //     if(root2 == null) {
        //         return root1;
        //     }
    
        //     TreeNode newRoot = new TreeNode(root1.val + root2.val);
    
        //     newRoot.left = mergeTrees(root1.left, root2.left);
    
        //     newRoot.right = mergeTrees(root1.right, root2.right);
    
        //     return newRoot;
        // }
    }
}
