/*
 * @Created on Wed Jun 08 2022 17:18:10
 * @ProblemLink https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Binary_Tree_Postorder_Traversal_145 {
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

        binaryTree.printPostorder();

        System.out.println((new Inner()).postorderTraversal(binaryTree.getRoot()));
        sc.close();
    }

    static class Inner {
        private List<Integer> list = new ArrayList<>();
        public List<Integer> postorderTraversal(BinaryTreeNode<Integer> root) {
            if(root == null) {
                return list;
            }

            postorderTraversal(root.getLeft());            
            postorderTraversal(root.getRight());
            list.add(root.getValue());
            
            return list;
        }

        // Leetcode solution
        // public List<Integer> postorderTraversal(TreeNode root) {
        //     if(root == null) {
        //         return list;
        //     }

        //     postorderTraversal(root.left);            
        //     postorderTraversal(root.right);
        //     list.add(root.val);
            
        //     return list;
        // }
    }
}
