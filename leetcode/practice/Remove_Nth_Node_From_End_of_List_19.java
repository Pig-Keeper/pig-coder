/*
 * @Created on Sat Jun 04 2022 15:07:08
 * @ProblemLink https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.SinglyLinkedList;
import geeksforgeeks.SinglyLinkedListNode;

public class Remove_Nth_Node_From_End_of_List_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

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
        // index taken from 0 to N - 1 whereas in question it is from 1 to N
        public SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode head, int index) {
            SinglyLinkedListNode temp = head;
            int count = 0;

            while(temp != null && count < index) {
                temp = temp.getNext();
                count++;
            }

            if (temp != null) {
                SinglyLinkedListNode prev = null;
                SinglyLinkedListNode curr = head;
    
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
    }
}
