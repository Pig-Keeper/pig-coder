/*
 * @Created on Thu Jun 09 2022 20:02:18
 * @ProblemLink https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import geeksforgeeks.binary_tree.BinaryTree;
import geeksforgeeks.binary_tree.BinaryTreeNode;

public class Binary_Tree_Level_Order_Traversal_102 {
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

        binaryTree.printInorder();

        System.out.println((new Inner()).levelOrder(binaryTree.getRoot()));
        sc.close();
    }

    static class Inner {
        public List<List<Integer>> levelOrder(BinaryTreeNode<Integer> root) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();

            if(root == null) {
                return list;
            }

            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(null);

            while(!queue.isEmpty()) {
                BinaryTreeNode<Integer> node = queue.poll();

                if(node == null) {
                    list.add(new ArrayList<>(tempList));
                    tempList.clear();
                    
                    if(queue.isEmpty()) {
                        return list;
                    } else {
                        queue.offer(null);
                        continue;
                    }
                }

                tempList.add(node.getValue());

                if(node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

                if(node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            return list;
        }

        //Leetcode solution
        // public List<List<Integer>> levelOrder(TreeNode root) {
        //     List<List<Integer>> list = new ArrayList<>();
        //     List<Integer> tempList = new ArrayList<>();

        //     if(root == null) {
        //         return list;
        //     }

        //     Queue<TreeNode> queue = new LinkedList<>();
        //     queue.offer(root);
        //     queue.offer(null);

        //     while(!queue.isEmpty()) {
        //         TreeNode node = queue.poll();

        //         if(node == null) {
        //             list.add(new ArrayList<>(tempList));
        //             tempList.clear();
                    
        //             if(queue.isEmpty()) {
        //                 return list;
        //             } else {
        //                 queue.offer(null);
        //                 continue;
        //             }
        //         }

        //         tempList.add(node.val);

        //         if(node.left != null) {
        //             queue.add(node.left);
        //         }

        //         if(node.right != null) {
        //             queue.add(node.right);
        //         }
        //     }
        //     return list;
        // }
    }
}
