/*
 * @Created on Sat Jun 04 2022 15:05:51
 * @ProblemLink https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Middle_of_the_Linked_List_876 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int size = sc.nextInt();
        for (int i = 0 ; i < size; i++) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        // Internal implementation of `geeksforgeeks.SinglyLinkedList`
        System.out.println(singlyLinkedList.getSecondMiddleNode().getValue());

        System.out.println((new Inner()).middleNode(singlyLinkedList.getHead()).getValue());

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission
        // also change the method `getNext()` to `next` and `setNext` to = *.next` 
        public SinglyLinkedListNode<Integer> middleNode(SinglyLinkedListNode<Integer> head) {
            SinglyLinkedListNode<Integer> fast = head;
            SinglyLinkedListNode<Integer> slow = head;

            while(fast != null && fast.getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext();
                if(fast != null) {
                    fast = fast.getNext();
                }
            }

            return slow;
        }

        // Leetcode submission
        // public ListNode middleNode(ListNode head) {
        //     ListNode fast = head;
        //     ListNode slow = head;

        //     while(fast != null && fast.next != null) {
        //         slow = slow.next;
        //         fast = fast.next;
        //         if(fast != null) {
        //             fast = fast.next;
        //         }
        //     }
        //     return slow;
        // }
    }
}
