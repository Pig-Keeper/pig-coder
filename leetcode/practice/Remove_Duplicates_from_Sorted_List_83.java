/*
 * @Created on Sun Jun 05 2022 01:24:27
 * @ProblemLink https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Remove_Duplicates_from_Sorted_List_83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        for(int i = 0; i < size; i++) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        (new Inner()).deleteDuplicates(singlyLinkedList.getHead()).printDeep();

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission
        // also change the method `getNext()` to `next` and `setNext` to = *.next` 
        public SinglyLinkedListNode<Integer> deleteDuplicates(SinglyLinkedListNode<Integer> head) {
            SinglyLinkedListNode<Integer> curr = head;

            while(curr != null && curr.getNext() != null) {
                if(curr.getValue() == curr.getNext().getValue()) {
                    curr.setNext(curr.getNext().getNext());
                } else {
                    curr = curr.getNext();
                }
            }
            return head;
        }

        // Submission to Leetcode
        // public ListNode deleteDuplicates(ListNode head) {
        //     ListNode curr = head;

        //     while(curr != null && curr.next != null) {
        //         if(curr.val == curr.next.data) {
        //             curr.next = curr.next.next;
        //         } else {
        //             curr = curr.next;
        //         }
        //     }
        //     return head;
        // }
    }
}
