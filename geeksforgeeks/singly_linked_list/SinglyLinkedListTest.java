/*
 * @Created on Fri Jun 03 2022 03:55:19
 *
 * @Author Pig Keeper
 */

package geeksforgeeks.singly_linked_list;

public class SinglyLinkedListTest {
    private Integer[] getIntegerArray(int[] arr) {
        int length = arr.length;
        Integer[] values = new Integer[length];

        for(int i = 0; i < length; i++) {
            values[i] = arr[i];
        }

        return values;
    }

    private <E extends Comparable<E>> SinglyLinkedListTest testValues(SinglyLinkedList<E> singlyLinkedList, E[] values) {
        SinglyLinkedListNode<E> curr = singlyLinkedList.getHead();
        int count = 0;

        while(curr != null && count < values.length && curr.getValue().compareTo(values[count]) == 0) {
            curr = curr.getNext();
            count++;
        }

        if(count == values.length && curr == null) {
            // System.out.println("*****************Success*********************");
            return this;
        }
        System.err.println("*****************Failed*********************");

        return this;
    }

    private <E extends Comparable<E>> SinglyLinkedListTest testNull(SinglyLinkedList<E> singlyLinkedList) {
        if(singlyLinkedList.getHead() == null) {
            // System.out.println("*****************Success*********************");
            return this;
        }
        System.err.println("*****************Failed*********************");
        return this;
    }

    private <E extends Comparable<E>> SinglyLinkedListTest testLength(SinglyLinkedList<E> singlyLinkedList, int length) {
        if(singlyLinkedList.length() == length) {
            // System.out.println("*****************Success*********************");
            return this;
        }
        System.err.println("*****************Failed*********************");
        return this;
    }

    private <E extends Comparable<E>> SinglyLinkedListTest testSearch(SinglyLinkedList<E> singlyLinkedList, E value, boolean result) {
        if(singlyLinkedList.searchIterative(value) == result && singlyLinkedList.searchRecursive(value) == result) {
            // System.out.println("*****************Success*********************");
            return this;
        }
        System.err.println("*****************Failed*********************");
        return this;
    }

    private <E extends Comparable<E>> SinglyLinkedListTest testValue(E value, E expect) {
        if(value.compareTo(expect) == 0) {
            // System.out.println("*****************Success*********************");
            return this;
        }
        System.err.println("*****************Failed*********************");
        return this;
    }

    private SinglyLinkedListTest testInsertAtFront() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testInsertAtFront")
        .insertAtFront(9)
        .insertAtFront(1)
        .insertAtFront(3)
        .insertAtFront(8)
        .insertAtFront(4)
        .print();

        return this.testValues(singlyLinkedList, this.getIntegerArray(new int[]{4, 8, 3, 1, 9}));
    }

    private SinglyLinkedListTest testInsertAtEnd() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testInsertAtEnd")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        return this.testValues(singlyLinkedList, this.getIntegerArray(new int[]{4, 8, 3, 1, 9}));
   }

    private SinglyLinkedListTest testInsertAtIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testInsertAtIndex")
        .insertAtIndex(4, 0)
        .insertAtIndex(9, 1)
        .insertAtIndex(8, 1)
        .insertAtIndex(3, 2)
        .insertAtIndex(1, 3)
        .print();

        return this.testValues(singlyLinkedList, this.getIntegerArray(new int[]{4, 8, 3, 1, 9}));
   }

    private SinglyLinkedListTest testInsertAfterValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testInsertAfterValue")
        .insertAtIndex(4, 0)
        .insertAfterValue(8, 4)
        .insertAfterValue(9, 8)
        .insertAfterValue(3, 8)
        .insertAfterValue(1, 3)
        .print();

        return this.testValues(singlyLinkedList, this.getIntegerArray(new int[]{4, 8, 3, 1, 9}));
   }

    private SinglyLinkedListTest testDeleteIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testDeleteIndex")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .deleteIndex(0)
        .deleteIndex(3)
        .deleteIndex(1)
        .print();

        return this.testValues(singlyLinkedList, this.getIntegerArray(new int[]{8, 1}));
   }   

    private SinglyLinkedListTest testDeleteValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testDeleteValue")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .deleteValue(4)
        .deleteValue(9)
        .deleteValue(3)
        .print();

        return this.testValues(singlyLinkedList, this.getIntegerArray(new int[]{8, 1}));
    }
    
    private SinglyLinkedListTest testDelete() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testDelete")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .delete()
        .print();

        return this
        .testValues(singlyLinkedList, this.getIntegerArray(new int[]{}))
        .testLength(singlyLinkedList, 0)
        .testNull(singlyLinkedList);
    }  
    
    private SinglyLinkedListTest testLength() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testLength")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .deleteValue(3)
        .print();

        return this.testLength(singlyLinkedList, 4);
    }
    
    private SinglyLinkedListTest testSearch() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testSearch")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        return this
        .testSearch(singlyLinkedList, 4, true)
        .testSearch(singlyLinkedList, 3, true)
        .testSearch(singlyLinkedList, 10, false);
    }

    private SinglyLinkedListTest testGetValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testGetValue")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        return this
        .testValue(singlyLinkedList.getValue(2), 3)
        .testValue(singlyLinkedList.getValue(0), 4)
        .testValue(singlyLinkedList.getValue(4), 9);
    }

    private SinglyLinkedListTest testGetValueFromEnd() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testGetValueFromEnd")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        return this
        .testValue(singlyLinkedList.getValueFromEnd(2), 3)
        .testValue(singlyLinkedList.getValueFromEnd(0), 9)
        .testValue(singlyLinkedList.getValueFromEnd(4), 4);
    }

    private SinglyLinkedListTest testGetFirstMiddleValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testGetFirstMiddleValue")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        this.testValue(singlyLinkedList.getFirstMiddleValue(), 3);

        singlyLinkedList
        .insertAtEnd(10)
        .print();

        return this.testValue(singlyLinkedList.getFirstMiddleValue(), 3);
    }    

    private SinglyLinkedListTest testGetSecondMiddleValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testGetSecondMiddleValue")
        .insertAtEnd(4)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        this.testValue(singlyLinkedList.getSecondMiddleValue(), 3);

        singlyLinkedList
        .insertAtEnd(10)
        .print();

        return this.testValue(singlyLinkedList.getSecondMiddleValue(), 1);
    } 

    private SinglyLinkedListTest testCountOccurrence() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testCountOccurrence")
        .insertAtEnd(4)
        .insertAtEnd(3)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .insertAtEnd(3)
        .print();

        return this
        .testValue(singlyLinkedList.countOccurrenceIterative(3), 3)
        .testValue(singlyLinkedList.countOccurrenceIterative(9), 1)
        .testValue(singlyLinkedList.countOccurrenceRecursive(3), 3)
        .testValue(singlyLinkedList.countOccurrenceRecursive(9), 1);
    } 

    private SinglyLinkedListTest testCreateLoop() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testCreateLoop")
        .insertAtEnd(4)
        .insertAtEnd(3)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .createLoop(-1)
        .print();

        this.testValue(singlyLinkedList.detectLoop(), false);
        
        singlyLinkedList.createLoop(2);

        return this.testValue(singlyLinkedList.detectLoop(), true);
    } 

    private SinglyLinkedListTest testDetectLoop() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testDetectLoop")
        .insertAtEnd(4)
        .insertAtEnd(3)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .createLoop(-1)
        .print();

        this.testValue(singlyLinkedList.detectLoop(), false);
        
        singlyLinkedList.createLoop(4);

        return this.testValue(singlyLinkedList.detectLoop(), true);
    } 

    private SinglyLinkedListTest testMergeSortedList() {
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>();

        singlyLinkedList1
        .print("SinglyLinkedListTest.testMergeSortedList")
        .insertAtEnd(1)
        .insertAtEnd(3)
        .insertAtEnd(5)
        .insertAtEnd(7)
        .insertAtEnd(9)
        .print();

        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>();

        singlyLinkedList2
        .insertAtEnd(2)
        .insertAtEnd(4)
        .insertAtEnd(6)
        .insertAtEnd(8)
        .print();

        return this.testValues(singlyLinkedList1.mergeSortedList(singlyLinkedList2).print(), getIntegerArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    private SinglyLinkedListTest testReverse() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testReverse")
        .insertAtEnd(4)
        .insertAtEnd(3)
        .insertAtEnd(8)
        .insertAtEnd(3)
        .insertAtEnd(1)
        .insertAtEnd(9)
        .print();

        return this.testValues(singlyLinkedList.reverse().print(), getIntegerArray(new int[]{9, 1, 3, 8, 3, 4}));
    } 

    private SinglyLinkedListTest testDeleteDuplicateFromSortedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList
        .print("SinglyLinkedListTest.testDeleteDuplicateFromSortedList")
        .insertAtEnd(1)
        .insertAtEnd(1)
        .insertAtEnd(2)
        .insertAtEnd(3)
        .insertAtEnd(3)
        .insertAtEnd(3)
        .print();

        return this.testValues(singlyLinkedList.deleteDuplicatesFromSortedList().print(), getIntegerArray(new int[]{1, 2, 3}));
    }

    public static void main(String[] args) {

        new SinglyLinkedListTest()
        .testInsertAtFront()
        .testInsertAtEnd()
        .testInsertAtIndex()
        .testInsertAfterValue()
        .testDeleteIndex()
        .testDeleteValue()
        .testDelete()
        .testLength()
        .testSearch()
        .testGetValue()
        .testGetValueFromEnd()
        // testGetFirstMiddleNode()
        .testGetFirstMiddleValue()
        // testGetSecondMiddleNode()
        .testGetSecondMiddleValue()
        .testCountOccurrence()
        .testCreateLoop()
        .testDetectLoop()
        .testMergeSortedList()
        .testReverse()
        .testDeleteDuplicateFromSortedList();
    }
}
