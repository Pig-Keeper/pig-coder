/*
 * @Created on Sat Jun 04 2022 15:07:08
 * @ProblemLink https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Remove_Nth_Node_From_End_of_List_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int size = sc.nextInt();
        for (int i = 0 ; i < size; i++) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        (new Inner()).removeNthFromEnd(singlyLinkedList.getHead(), sc.nextInt()).printDeep();

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission
        // also change the method `getNext()` to `next` and `setNext` to = *.next` 
        // index taken from 0 to N - 1 whereas in question it is from 1 to N
        public SinglyLinkedListNode<Integer> removeNthFromEnd(SinglyLinkedListNode<Integer> head, int index) {
            SinglyLinkedListNode<Integer> temp = head;
            int count = 0;

            while(temp != null && count < index) {
                temp = temp.getNext();
                count++;
            }

            if (temp != null) {
                SinglyLinkedListNode<Integer> prev = null;
                SinglyLinkedListNode<Integer> curr = head;
    
                while(temp.getNext() != null) {
                    prev = curr;
                    curr = curr.getNext();
                    temp = temp.getNext();
                }
    
                if (prev == null) {
                    head = head.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
            }

            return head;
        }

        // Leetcode submission
        // // Index is 1 to N while I have written code for 0 to N - 1
        // public ListNode removeNthFromEnd(ListNode head, int index) {
        //     ListNode temp = head;
        //     index--;
        //     int count = 0;
        //     // move temp ahead by index position
        //     while(temp != null && count < index) {
        //         temp = temp.next;
        //         count++;
        //     }

        //     if (temp != null) {
        //         ListNode prev = null;
        //         ListNode curr = head;
    
        //         // start curr from start
        //         // move both curr and temp by one
        //         // when temp reaches last curr reaches nth node from end
        //         while(temp.next != null) {
        //             prev = curr;
        //             curr = curr.next;
        //             temp = temp.next;
        //         }
    
        //         if (prev == null) {
        //             head = head.next;
        //         } else {
        //             prev.next = curr.next;
        //         }
        //     }

        //     return head;
        // }
    }
}
