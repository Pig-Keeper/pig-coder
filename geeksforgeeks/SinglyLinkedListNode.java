/*
 * @Created on Fri Jun 03 2022 03:04:42
 * @ProblemLink https://www.geeksforgeeks.org/data-structures/linked-list/#singlyLinkedList
 *
 * @Author Pig Keeper
 */

package geeksforgeeks;

public class SinglyLinkedListNode {
    private int data;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    public SinglyLinkedListNode getNext() {
        return this.next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    public void print() {
        System.out.println(data);
    }

    public void printDeep() {
        System.out.print(data);
        if(this.next != null) {
            System.out.print("->");
            this.next.printDeep();;
        }
    }
}
