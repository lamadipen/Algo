package kata.linkedlist;

/**
 * Find  the kth to last element of singly linked list
 */
public class FindKthItemToLastElement {
    public Node findKthToLastIterative(CustomLinkedList customLinkedList, int kthItem) {
        Node tempHead = customLinkedList.getHead();
        int lengthOfLinkedList = 0;
        while (tempHead != null) {
            tempHead = tempHead.getNext();
            lengthOfLinkedList++;
        }

        int target = lengthOfLinkedList - kthItem;
        Node current = customLinkedList.getHead();
        for (int i = 0; i < target; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void findKthToLastRecursive(CustomLinkedList customLinkedList, int kthItem) {
        findKthToLastRecursive(customLinkedList.getHead(), kthItem);
    }

    public int findKthToLastRecursive(Node currentHead, int kthItem) {
        if (currentHead == null) {
            return 0;
        }
        int index = findKthToLastRecursive(currentHead.getNext(), kthItem) + 1;
        if (index == kthItem) {
            System.out.println(currentHead.getData());
        }

        return index;
    }

    public Node findKthToLastRecursiveObject(CustomLinkedList customLinkedList, int kthItem) {
        return findKthToLastRecursiveObject(customLinkedList.getHead(), kthItem, new Index());
    }

    public Node findKthToLastRecursiveObject(Node head, int kthItem, Index index) {
        if (head == null) {
            return  null;
        }
        Node returnedNode = findKthToLastRecursiveObject(head.getNext(), kthItem, index);
        index.value = index.value + 1;

        if (index.value == kthItem) {
            return head;
        }
        return returnedNode;
    }
}

class Index{
    int value = 0;
}
