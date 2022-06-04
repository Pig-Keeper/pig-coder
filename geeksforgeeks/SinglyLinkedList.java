/*
 * @Created on Fri Jun 03 2022 03:04:58
 * @ProblemLink https://www.geeksforgeeks.org/data-structures/linked-list/#singlyLinkedList
 *
 * @Author Pig Keeper
 */

package geeksforgeeks;

public class SinglyLinkedList {
    private SinglyLinkedListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public SinglyLinkedListNode getHead() {
        return this.head;
    }
    
    /*
     * @Created on Fri Jun 03 2022 03:11:02
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList insertAtFront(int data) {
        head = new SinglyLinkedListNode(data, head);
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:10:30
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList insertAtEnd(int data) {
        if(head == null) {
            head = new SinglyLinkedListNode(data);
        } else {
            SinglyLinkedListNode temp = head;
            while(temp.getNext() != null) {
                 temp = temp.getNext();
            }
            temp.setNext(new SinglyLinkedListNode(data));
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:17:28
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList insertAfterGivenData(int data, int givenData) {
        if(head == null) {
            head = new SinglyLinkedListNode(data);
        } else {
            SinglyLinkedListNode temp = head;
            while(temp != null && temp.getData() != givenData) {
                 temp = temp.getNext();
            }
            if(temp != null) {
                temp.setNext(new SinglyLinkedListNode(data, temp.getNext()));
            } else {
                System.out.println("insertAfterGivenData: The given data '" + givenData + "' does not exists");
            }
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:18:02
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList insertAtIndex(int data, int index) {
        int count = 0;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;
        while(curr != null && count < index) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if(count == index) {
            if(prev == null) {
                head = new SinglyLinkedListNode(data, head);
            } else  {
                prev.setNext(new SinglyLinkedListNode(data, curr));
            }
        } else{
            System.out.println("insertAtIndex: The given index '" + index + "' is greater than the list length");
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 03:36:44
     * @ProblemLink  https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     */
    public SinglyLinkedList insertAfterNode(int data, SinglyLinkedListNode node) {
        if(node == null) {
            System.out.println("insertAtNode: The given node is 'null'");
        } else {
            node.setNext(new SinglyLinkedListNode(data, node.getNext()));
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:14:55
     * @ProblemLink https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
     */
    public SinglyLinkedList deleteAGivenNode(SinglyLinkedListNode node) {
        if(node == null) {
            System.out.println("deleteAGivenNode: The given node is 'null'");
        } else {
            if(node == head) {
                head = head.getNext();
            } else {
                SinglyLinkedListNode prev = null;
                SinglyLinkedListNode curr = head;
                while(curr != null && curr != node) {
                    prev = curr;
                    curr = curr.getNext();
                }
                if(curr == null) {
                    System.out.println("deleteAGivenNode: The given node does not exists");
                } else {
                    prev.setNext(prev.getNext().getNext());
                }
            }
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:15:02
     * @ProblemLink https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
     */
    public SinglyLinkedList deleteAGivenIndex(int index) {
        if(head == null) {
            System.out.println("deleteAGivenIndex: The given index '" + index + "' is greater than the list length");
        } else {
            int count = 0;
            SinglyLinkedListNode prev = null;
            SinglyLinkedListNode curr = head;
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
                System.out.println("deleteAGivenIndex: The given index '" + index + "' is greater than the list length");
            }
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:15:13
     * @ProblemLink https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
     */
    public SinglyLinkedList deleteAGivenData(int data) {
        if(head == null) {
            System.out.println("deleteAGivenData: The given data '" + data + "' does not exists");
        } else {
            SinglyLinkedListNode prev = null;
            SinglyLinkedListNode curr = head;
            while(curr != null && curr.getData() != data) {
                prev = curr;
                curr = curr.getNext();
            }
    
            if(curr != null && curr.getData() == data) {
                if(prev == null) {
                    head = head.getNext();
                } else  {
                    prev.setNext(curr.getNext());
                }
            } else {
                System.out.println("deleteAGivenData: The given data '" + data + "' does not exists");
            }
        }
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:20:19
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-to-delete-a-linked-list/
     */

    public SinglyLinkedList deleteList() {
        this.head = null;
        return this;
    }

    /*
     * @Created on Fri Jun 03 2022 05:20:41
     * @ProblemLink https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
     */
    public int getLength() {
        int count = 0;
        SinglyLinkedListNode temp = head;
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
    public boolean searchIterative(int data){
        SinglyLinkedListNode temp = head;
        while(temp != null) {
            if(temp.getData() == data) {
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
    public boolean searchRecursive(int data){
        return searchRecursiveUtil(this.head, data);
    }

    private boolean searchRecursiveUtil(SinglyLinkedListNode node, int data) {
        if(node == null) {
            return false;
        }

        if(node.getData() == data) {
            return true;
        }

        return searchRecursiveUtil(node.getNext(), data);
    }

    /*
     * @Created on Fri Jun 03 2022 05:35:47
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
     */
    public int getdataAtIndex(int index) {
        int count = 0;
        SinglyLinkedListNode curr = head;

        while(curr != null && count != index) {
            curr = curr.getNext();
            count++;
        }

        if(index == count) {
            return curr.getData();
        } else {
            System.out.println("getdataAtIndex: The passed index '" + index + "' is greater than list length");
        }
        return -1;
    }

    /*
     * @Created on Fri Jun 03 2022 05:59:45
     * @ProblemLink https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
     */
    public int getDataFromEndAtIndex(int index) {
        int count = 0;
        SinglyLinkedListNode temp = head;
        while(temp != null && count < index) {
            temp = temp.getNext();
            count++;
        }

        if(temp == null) {
            System.out.println("getDataFromEndAtIndex: The passed index '" + index + "' is greater than list length");
        } else {
            SinglyLinkedListNode curr = head;
            while(temp.getNext() != null) {
                curr = curr.getNext();
                temp = temp.getNext();
            }
            return curr.getData();
        }
        return -1;
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public int getFirstMiddleData() {
        if(head == null) {
            return -1;
        } else {
            return this.getFirstMiddleNode().getData();
        }
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public SinglyLinkedListNode getFirstMiddleNode() {
        SinglyLinkedListNode fast = head;
        SinglyLinkedListNode slow = head;

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
    public int getSecondMiddleData() {
        if(head == null) {
            return -1;
        } else {
            return this.getSecondMiddleNode().getData();
        }
    }

    /*
     * @Created on Fri Jun 03 2022 06:05:04
     * @ProblemLink geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     */
    public SinglyLinkedListNode getSecondMiddleNode() {
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

    /*
     * @Created on Fri Jun 03 2022 06:18:22
     * @ProblemLink https://www.geeksforgeeks.org/write-a-function-that-counts-the-number-of-times-a-given-int-occurs-in-a-linked-list/
     */
    public int countOccurrenceOfDataIterative(int data) {
        SinglyLinkedListNode curr = head;
        int count = 0;
        while(curr != null) {
            if(curr.getData() == data) {
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
    public int countOccurrenceOfDataRecursive(int data) {
        return countOccurrenceOfDataRecursiveUtil(this.head, data);
    }

    private int countOccurrenceOfDataRecursiveUtil(SinglyLinkedListNode node, int data) {
        if(node == null) {
            return 0;
        }

        if(node.getData() == data) {
            return countOccurrenceOfDataRecursiveUtil(node.getNext(), data) + 1;
        } else {
            return countOccurrenceOfDataRecursiveUtil(node.getNext(), data);
        }
    }

    /*
     * @Created on Fri Jun 03 2022 03:11:57
     * @ProblemLink `Enter Problem Link here`
     */
    public SinglyLinkedList print(String msg) {
        SinglyLinkedListNode temp = head;
        if(!msg.isBlank()) {
            System.out.print(msg + " : ");
        }
        
        while(temp != null) {
            System.out.print(temp.getData());
            temp = temp.getNext();
            if(temp != null) {
                System.out.print("->");
            }
        }
        System.out.println("");
        return this;
    }

    public SinglyLinkedList print() {
        return this.print("");
    }

    public SinglyLinkedList printAndClear(String msg) {
        this.print(msg);
        return this.deleteList();
    }

    public SinglyLinkedList printAndClear() {
        return this.printAndClear("");
    }
}
