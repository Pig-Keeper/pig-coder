/*
 * @Created on Mon Jun 13 2022 17:11:29
 * @ProblemLink https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Two_Sum_IV_Input_is_a_BST_653 {
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
        // assume BT is BST
        // @todo change to BST
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        System.out.println((new Inner()).findTarget(binaryTree.getRoot(), targetSum));
        
        sc.close();
    } 

    static class Inner {
        private HashSet<Integer> hashSet = new HashSet<>();

        public boolean findTarget(BinaryTreeNode<Integer> root, int targetSum) {
            if(root == null) {
                return false;
            }

            if(hashSet.contains(root.getValue())) {
                return true;
            }

            hashSet.add(targetSum - root.getValue());

            return findTarget(root.getLeft(), targetSum) || findTarget(root.getRight(), targetSum);
        }
    }
}
