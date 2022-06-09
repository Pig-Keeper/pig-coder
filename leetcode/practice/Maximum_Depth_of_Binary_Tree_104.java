/*
 * @Created on Wed Jun 08 2022 17:55:27
 * @ProblemLink https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Maximum_Depth_of_Binary_Tree_104 {
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

        System.out.println((new Inner()).maxDepth(binaryTree.getRoot()));
        sc.close();
    }

    static class Inner {
        public int maxDepth(BinaryTreeNode<Integer> root) {
            if(root == null) {
                return 0;
            }

            return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
        }
    }
}
