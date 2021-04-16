package hackerrank.interviewprepkit.linkedlist;

public class InsertingNodeIntoSortedDoublyLinkedListSolution {
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }

        if (data < head.data) {
            DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
            temp.next = head;
            head.prev = temp;
            return temp;
        }

        if (head.next == null) {
            DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
            head.next = temp;
            temp.prev = head;
            return head;
        }

        DoublyLinkedListNode current = head;
        while (current != null) {
            if (current.data < data) {
                current = current.next;
            } else {
                DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
                temp.prev = current.prev;
                temp.next = current;
                current.prev.next = temp;
                current.prev = temp;
                return head;
            }
        }

        DoublyLinkedListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
        temp.prev = last;
        last.next = temp;


        return head;
    }


    static DoublyLinkedListNode sortedInsertRecursive(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if (head == null) {
            return node;
        } else if (data <= head.data) {
            node.next = head;
            head.prev = node;
            return node;
        } else {
            DoublyLinkedListNode current = sortedInsertRecursive(head.next, data);
            head.next = current;
            current.prev = head;
            return head;
        }
    }
}

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }
}


