/*
 * @Created on Mon Jun 13 2022 19:45:42
 * @ProblemLink https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
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


        int pValue = sc.nextInt();
        int qvalue = sc.nextInt();
        // assume BT is BST
        // @todo change to BST
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        System.out.println((new Inner()).lowestCommonAncestor(binaryTree.getRoot(), new BinaryTreeNode<Integer>(pValue), new BinaryTreeNode<Integer>(qvalue)).getValue());
        
        sc.close();
    }

    static class Inner {
        public BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
            return findPQ(root, p ,q) ? lowestCommonAncestorUtil(root, p, q) : null;
        }



        private BinaryTreeNode<Integer> lowestCommonAncestorUtil(BinaryTreeNode<Integer> root,
                BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {

                    if(root.getValue() < p.getValue() && root.getValue() < q.getValue()) {
                        return lowestCommonAncestorUtil(root.getRight(), p, q);
                    }
        
                    if(root.getValue() > p.getValue() && root.getValue() > q.getValue()) {
                        return lowestCommonAncestorUtil(root.getLeft(), p, q);
                    }

                    return root;
        }



        private boolean findPQ(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
            if(root == null) {
                return false;
            }
            
            if(root.getValue() < p.getValue() && root.getValue() < q.getValue()) {
                return findPQ(root.getRight(), p, q);
            }

            if(root.getValue() > p.getValue() && root.getValue() > q.getValue()) {
                return findPQ(root.getLeft(), p, q);
            }

            return find(root, p) && find(root, q);
        }

        private boolean find(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> curr) {
            if(root == null) {
                return false;
            }

            if(root.getValue() == curr.getValue()) {
                return true;
            }

            return find(root.getLeft(), curr) || find(root.getRight(), curr);
        }
    }
}
