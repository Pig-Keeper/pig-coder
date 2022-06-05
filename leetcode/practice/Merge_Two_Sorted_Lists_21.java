/*
 * @Created on Sat Jun 04 2022 16:17:41
 * @ProblemLink https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Merge_Two_Sorted_Lists_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>();

        for(int i = 0; i < size1; i++) {
            singlyLinkedList1.insertAtEnd(sc.nextInt());
        }

        for(int i = 0; i < size2; i++) {
            singlyLinkedList2.insertAtEnd(sc.nextInt());
        }

        // internal implementation of geeksforgeeks.SinglyLinkedList
        // uncommenting it will change the list1 and list2
        // System.out.println(
        //     singlyLinkedList1
        //     .mergeTwoSortedList(singlyLinkedList1, singlyLinkedList2)
        //     .print()
        // );

        (new Inner()).mergeTwoLists(singlyLinkedList1.getHead(), singlyLinkedList2.getHead()).printDeep();

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission
        // also change the method `getNext()` to `next` and `setNext` to = *.next` 
        public SinglyLinkedListNode<Integer> mergeTwoLists(SinglyLinkedListNode<Integer> singlyLinkedListNode1, SinglyLinkedListNode<Integer> singlyLinkedListNode2) {
            if(singlyLinkedListNode1 == null) {
                return singlyLinkedListNode2;
            }

            if(singlyLinkedListNode2 == null) {
                return singlyLinkedListNode1;
            }

            if(singlyLinkedListNode1.getValue().compareTo(singlyLinkedListNode2.getValue()) < 0) {
                singlyLinkedListNode1.setNext(mergeTwoLists(singlyLinkedListNode1.getNext(), singlyLinkedListNode2));
                return singlyLinkedListNode1;
            } else {
                singlyLinkedListNode2.setNext(mergeTwoLists(singlyLinkedListNode1, singlyLinkedListNode2.getNext()));
                return singlyLinkedListNode2;
            }
        }

        // Leetcode submission
        // public ListNode mergeTwoLists(ListNode singlyLinkedListNode1, ListNode singlyLinkedListNode2) {
        //     if(singlyLinkedListNode1 == null) {
        //         return singlyLinkedListNode2;
        //     }

        //     if(singlyLinkedListNode2 == null) {
        //         return singlyLinkedListNode1;
        //     }

        //     if(singlyLinkedListNode1.val < singlyLinkedListNode2.val) {
        //         singlyLinkedListNode1.next = mergeTwoLists(singlyLinkedListNode1.next, singlyLinkedListNode2);
        //         return singlyLinkedListNode1;
        //     } else {
        //         singlyLinkedListNode2.next = mergeTwoLists(singlyLinkedListNode1, singlyLinkedListNode2.next);
        //         return singlyLinkedListNode2;
        //     }
        // }
    }
}
