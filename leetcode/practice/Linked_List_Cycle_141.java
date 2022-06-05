/*
 * @Created on Sat Jun 04 2022 15:43:48
 * @ProblemLink https://leetcode.com/problems/linked-list-cycle/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

import geeksforgeeks.singly_linked_list.SinglyLinkedList;
import geeksforgeeks.singly_linked_list.SinglyLinkedListNode;

public class Linked_List_Cycle_141 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        while(size-- > 0) {
            singlyLinkedList.insertAtEnd(sc.nextInt());
        }

        singlyLinkedList.createLoop(sc.nextInt());

        // internal implementation of geeksforgeeks.SinglyLinkedList
        System.out.println(singlyLinkedList.detectLoop());

        System.out.println((new Inner()).hasCycle(singlyLinkedList.getHead()));

        sc.close();
    }

    static class Inner {
        // Leetcode solution has parameter type to ListNode
        // change all `SinglyLinkedListNode` to `ListNode` while submission
        // also change the method `getNext()` to `next` and `setNext` to = *.next` 
        public boolean hasCycle(SinglyLinkedListNode<Integer> head) {
            SinglyLinkedListNode<Integer> slow = head, fast = head;

            while(fast != null && fast.getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
                if(slow == fast) {
                    return true;
                }
            }
            
            return false;
        }

        // Leetcode submission
        // public boolean hasCycle(ListNode head) {
        //     ListNode slow = head, fast = head;
    
        //     while(fast != null && fast.next != null) {
        //         slow = slow.next;
        //         fast = fast.next.next;
        //         if(slow == fast) {
        //             return true;
        //         }
        //     }
    
        //     return false;
        // }
    }
}
