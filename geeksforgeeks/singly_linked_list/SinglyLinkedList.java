/*
 * @Created on Fri Jun 03 2022 03:04:58
 * @ProblemLink https://www.geeksforgeeks.org/data-structures/linked-list/#singlyLinkedList
 *
 * @Author Pig Keeper
 */

package geeksforgeeks.singly_linked_list;

public class SinglyLinkedList<T extends Comparable<T>> {

    private SinglyLinkedListNode<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }
    
    public SinglyLinkedListNode<T> getHead() {
        return this.head;
    }
    
    /*
     * @Created on Fri Jun 03 2022 03:11:02
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList<T> insertAtFront(T value) {
        head = new SinglyLinkedListNode<T>(value, head);
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:10:30
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList<T> insertAtEnd(T value) {
        if(head == null) {
            head = new SinglyLinkedListNode<T>(value);
            return this;
        }

        SinglyLinkedListNode<T> temp = head;

        while(temp.getNext() != null) {
             temp = temp.getNext();
        }

        temp.setNext(new SinglyLinkedListNode<T>(value));

        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:18:02
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList<T> insertAtIndex(T value, int index) {
        int count = 0;
        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> curr = head;

        while(curr != null && count != index) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if(count == index) {
            if(prev == null) {
                head = new SinglyLinkedListNode<T>(value, head);
            } else  {
                prev.setNext(new SinglyLinkedListNode<T>(value, curr));
            }
        } else{
            System.out.println("SinglyLinkedList.insertAtIndex: The given index '" + index + "' is greater than the list length");
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:17:28
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList<T> insertAfterValue(T value, T givenValue) {
        if(head == null) {
            head = new SinglyLinkedListNode<T>(value);
            return this;
        }

        SinglyLinkedListNode<T> temp = head;
        
        while(temp != null && temp.getValue() != givenValue) {
             temp = temp.getNext();
        }
        
        if(temp != null) {
            temp.setNext(new SinglyLinkedListNode<T>(value, temp.getNext()));
        } else {
            System.out.println("SinglyLinkedList.insertAfterGivenValue: The given data '" + givenValue + "' does not exists");
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:36:44
     * @ProblemLink  https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList<T> insertAfterNode(T value, SinglyLinkedListNode<T> node) {
        if(node == null) {
            System.out.println("SinglyLinkedListinsertAtNode: The given node is 'null'");
        } else {
            node.setNext(new SinglyLinkedListNode<T>(value, node.getNext()));
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:14:55
     * @ProblemLink https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
     */
    public SinglyLinkedList<T> deleteNode(SinglyLinkedListNode<T> node) {
        if(node == null) {
            System.out.println("SinglyLinkedList.deleteAGivenNode: The given node is 'null'");
            return this;
        }

        if(node == head) {
            head = head.getNext();
        } else {
            SinglyLinkedListNode<T> prev = null;
            SinglyLinkedListNode<T> curr = head;
            while(curr != null && curr != node) {
                prev = curr;
                curr = curr.getNext();
            }
            if(curr == null) {
                System.out.println("SinglyLinkedList.deleteAGivenNode: The given node does not exists");
            } else {
                prev.setNext(prev.getNext().getNext());
            }
        }

        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:15:02
     * @ProblemLink https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
     */
    public SinglyLinkedList<T> deleteIndex(int index) {
        if(head == null) {
            System.out.println("SinglyLinkedList.deleteAGivenIndex: The given index '" + index + "' is greater than the list length");
            return this;
        }

        int count = 0;
        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> curr = head;
        while(curr != null && count < index) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if(count == index && curr != null) {
            if(prev == null) {
                head = head.getNext();
            } else  {
                prev.setNext(curr.getNext());
            }
        } else {
            System.out.println("SinglyLinkedList.deleteAGivenIndex: The given index '" + index + "' is greater than the list length");
        }

        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:15:13
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
     */
    public SinglyLinkedList<T> deleteValue(T value) {
        if(head == null) {
            System.out.println("SinglyLinkedList.deleteAGivenData: The given value '" + value + "' does not exists");
            return this;
        }

        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> curr = head;
        while(curr != null && curr.getValue() != value) {
            prev = curr;
            curr = curr.getNext();
        }

        if(curr != null && curr.getValue() == value) {
            if(prev == null) {
                head = head.getNext();
            } else  {
                prev.setNext(curr.getNext());
            }
        } else {
            System.out.println("SinglyLinkedList.deleteAGivenData: The given value '" + value + "' does not exists");
        }

        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:20:19
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-to-delete-a-linked-list/
     */

    public SinglyLinkedList<T> delete() {
        this.head = null;
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:20:41
     * @ProblemLink https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
     */
    public int length() {
        int count = 0;
        SinglyLinkedListNode<T> temp = head;
        while(temp != null) {
            count ++;
            temp = temp.getNext();
        }
        return count;
    }

    /*
     * @Created on Fri Jun 03 2022 05:26:03
     * @ProblemLink https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
     */
    public boolean searchIterative(T value){
        SinglyLinkedListNode<T> temp = head;
        while(temp != null) {
            if(temp.getValue() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    /*
     * @Created on Fri Jun 03 2022 05:26:26
     * @ProblemLink https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
     */
    public boolean searchRecursive(T value){
        return searchRecursive(head, value);
    }

    private boolean searchRecursive(SinglyLinkedListNode<T> node, T value) {
        if(node == null) {
            return false;
        }

        if(node.getValue() == value) {
            return true;
        }

        return searchRecursive(node.getNext(), value);
    }

    /*
     * @Created on Fri Jun 03 2022 05:35:47
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
     */
    public T getValue(int index) {
        int count = 0;
        SinglyLinkedListNode<T> curr = head;

        while(curr != null && count != index) {
            curr = curr.getNext();
            count++;
        }

        if(index == count) {
            return curr.getValue();
        } else {
            System.out.println("SinglyLinkedList.getValueAtIndex: The passed index '" + index + "' is greater than list length");
        }
        return null;
    }

    /*
     * @Created on Fri Jun 03 2022 05:59:45
     * @ProblemLink https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
     */
    public T getValueFromEnd(int index) {
        int count = 0;
        SinglyLinkedListNode<T> temp = head;

        while(temp != null && count < index) {
            temp = temp.getNext();
            count++;
        }

        if(temp == null) {
            System.out.println("getDataFromEndAtIndex: The passed index '" + index + "' is greater than list length");
            return null;
        }

        SinglyLinkedListNode<T> curr = head;
        
        while(temp.getNext() != null) {
            curr = curr.getNext();
            temp = temp.getNext();
        }

        return curr.getValue();
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public T getFirstMiddleValue() {
        return head == null ? null : this.getFirstMiddleNode().getValue();
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public SinglyLinkedListNode<T> getFirstMiddleNode() {
        SinglyLinkedListNode<T> fast = head;
        SinglyLinkedListNode<T> slow = head;

        while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public T getSecondMiddleValue() {
        return head == null ? null : this.getSecondMiddleNode().getValue();
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public SinglyLinkedListNode<T> getSecondMiddleNode() {
        SinglyLinkedListNode<T> fast = head;
        SinglyLinkedListNode<T> slow = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    /*
     * @Created on Fri Jun 03 2022 06:18:22
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-that-counts-the-number-of-times-a-given-int-occurs-in-a-linked-list/
     */
    public int countOccurrenceIterative(T value) {
        SinglyLinkedListNode<T> curr = head;
        int count = 0;

        while(curr != null) {
            if(curr.getValue() == value) {
                count++;
            }
            curr = curr.getNext();
        }
        return count;
    } 

    /*
     * @Created on Fri Jun 03 2022 06:18:22
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-that-counts-the-number-of-times-a-given-int-occurs-in-a-linked-list/
     */
    public int countOccurrenceRecursive(T value) {
        return countOccurrenceRecursive(head, value);
    }

    private int countOccurrenceRecursive(SinglyLinkedListNode<T> node, T value) {
        if(node == null) {
            return 0;
        }

        if(node.getValue() == value) {
            return countOccurrenceRecursive(node.getNext(), value) + 1;
        } else {
            return countOccurrenceRecursive(node.getNext(), value);
        }
    }

    public SinglyLinkedList<T> createLoop(int index) {
        SinglyLinkedListNode<T> temp = head;
        int count = 0;

        if(index == -1) {
            // case when no loop needs to be created
            return this;
        }

        while(count != index && temp != null) {
            temp = temp.getNext();
            count++;
        }

        if(count == index && temp != null) {
            SinglyLinkedListNode<T> curr = temp;
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(temp);
        } else {
            System.out.println("SinglyLinkedList.createLoop : The given index : '" + index + "' is greater than list length");
        }

        return this;
    }

    /*
     * @Created on Sat Jun 04 2022 15:44:10
     * @ProblemLink https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
     */
    public boolean detectLoop() {
        SinglyLinkedListNode<T> slow = head, fast = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    /*
     * @Created on Sat Jun 04 2022 16:05:08
     * @ProblemLink https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
     */
    public SinglyLinkedList<T> mergeSortedList(SinglyLinkedList<T> singlyLinkedList2) {
        this.head = mergeTwoSortedList(this.getHead(), singlyLinkedList2.getHead());
        return this;
    }

    private SinglyLinkedListNode<T> mergeTwoSortedList(SinglyLinkedListNode<T> singlyLinkedListNode1, SinglyLinkedListNode<T> singlyLinkedListNode2) {
        if(singlyLinkedListNode1 == null) {
            return singlyLinkedListNode2;
        }

        if(singlyLinkedListNode2 == null) {
            return singlyLinkedListNode1;
        }

        if(singlyLinkedListNode1.getValue().compareTo(singlyLinkedListNode2.getValue()) < 0) {
            singlyLinkedListNode1.setNext(mergeTwoSortedList(singlyLinkedListNode1.getNext(), singlyLinkedListNode2));
            return singlyLinkedListNode1;
        } else {
            singlyLinkedListNode2.setNext(mergeTwoSortedList(singlyLinkedListNode1, singlyLinkedListNode2.getNext()));
            return singlyLinkedListNode2; 
        }
    }

    /*
     * @Created on Sun Jun 05 2022 00:46:20
     * @ProblemLink https://www.geeksforgeeks.org/reverse-a-linked-list/
     */
    public SinglyLinkedList<T> reverse() {
        head = reverse(head);
        return this;
    } 

    private SinglyLinkedListNode<T> reverse(SinglyLinkedListNode<T> node) {
        if(node == null || node.getNext() == null) {
            return node;
        }

        SinglyLinkedListNode<T> head = reverse(node.getNext());

        node.getNext().setNext(node);
        node.setNext(null);

        return head;
    }

    /*
     * @Created on Sun Jun 05 2022 01:19:46
     * @ProblemLink https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
     */
    public SinglyLinkedList<T> deleteDuplicatesFromSortedList() {
        SinglyLinkedListNode<T> curr = head;

        while(curr != null && curr.getNext() != null) {
            if(curr.getValue() == curr.getNext().getValue()) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }
        }

        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:11:57
     * @ProblemLink `Enter Problem Link here`
     */
    public SinglyLinkedList<T> print(String msg) {
        SinglyLinkedListNode<T> temp = head;

        if(!msg.isBlank()) {
            System.out.print(msg);
        }
        
        while(temp != null) {
            System.out.print(temp.getValue());
            temp = temp.getNext();
            if(temp != null) {
                System.out.print("->");
            }
        }

        System.out.println("");
        return this;
    }

    public SinglyLinkedList<T> print() {
        return this.print("");
    }
}
