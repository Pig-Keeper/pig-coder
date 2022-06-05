/*
 * @Created on Sun Jun 05 2022 00:46:49
 * @ProblemLink https://leetcode.com/problems/reverse-linked-list/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Reverse_Linked_List_206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        for(int i = 0; i < size; i++) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        SinglyLinkedListNode<Integer> result = (new Inner()).reverseList(singlyLinkedList.getHead());
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
        public SinglyLinkedListNode<Integer> reverseList(SinglyLinkedListNode<Integer> head) {
            if(head == null || head.getNext() == null) {
                return head;
            }

            SinglyLinkedListNode<Integer> temp = reverseList(head.getNext());

            head.getNext().setNext(head);
            head.setNext(null);

            return temp;
        }

        // Submission to Leetcode
        // public ListNode reverseList(ListNode head) {
        //     if(head == null || head.next == null) {
        //         return head;
        //     }

        //     ListNode temp = reverseList(head.next);

        //     head.next.next = head;
        //     head.next = null;

        //     return temp;
        // }
    }
}
