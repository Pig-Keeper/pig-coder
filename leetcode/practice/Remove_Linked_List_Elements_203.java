/*
 * @Created on Sun Jun 05 2022 00:10:02
 * @ProblemLink https://leetcode.com/problems/remove-linked-list-elements/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Remove_Linked_List_Elements_203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        for(int i = 0; i < size; i++) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        int value = sc.nextInt();

        SinglyLinkedListNode<Integer> result = (new Inner()).removeElements(singlyLinkedList.getHead(), value);
        if(result == null) {
            System.out.println("null");
        } else {
            result.printDeep();
        }

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission
        // also change the method `getNext()` to `next` and `setNext` to = *.next` 
        public SinglyLinkedListNode<Integer> removeElements(SinglyLinkedListNode<Integer> head, int value) {
            SinglyLinkedListNode<Integer> prev = null;
            SinglyLinkedListNode<Integer> curr = head;

            while(curr != null) {
                if(curr.getValue() == value && prev == null) {
                    head = head.getNext();
                    curr = head;
                } else if (curr.getValue() == value) {
                    prev.setNext(curr.getNext());
                    curr = curr.getNext();
                } else {
                    prev = curr;
                    curr= curr.getNext();
                }
            }

            return head;
        }

        // Submission to Leetcode
        // public ListNode removeElements(ListNode head, int value) {
        //     ListNode prev = null;
        //     ListNode curr = head;

        //     while(curr != null) {
        //         if(curr.val == value && prev == null) {
        //             head = head.next;
        //             curr = head;
        //         } else if (curr.val == value) {
        //             prev.next = curr.next;
        //             curr = curr.next;
        //         } else {
        //             prev = curr;
        //             curr= curr.next;
        //         }
        //     }

        //     return head;
        // }
    }
}
