/*
 * @Created on Sat Jun 04 2022 15:05:51
 * @ProblemLink https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.SinglyLinkedList;
import geeksforgeeks.SinglyLinkedListNode;

public class Middle_of_the_Linked_List_876 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        int size = sc.nextInt();
        for (int i = 0 ; i < size; i++) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        // Internal implementation of `geeksforgeeks.SinglyLinkedList`
        System.out.println(singlyLinkedList.getSecondMiddleNode().getData());

        System.out.println((new Inner()).middleNode(singlyLinkedList.getHead()).getData());

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission

        public SinglyLinkedListNode middleNode(SinglyLinkedListNode head) {
            SinglyLinkedListNode fast = head;
            SinglyLinkedListNode slow = head;

            while(fast != null && fast.getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext();
                if(fast != null) {
                    fast = fast.getNext();
                }
            }
            return slow;
        }
    }
}
