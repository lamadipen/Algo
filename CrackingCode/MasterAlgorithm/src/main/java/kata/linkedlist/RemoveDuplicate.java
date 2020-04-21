package kata.linkedlist;

import java.util.HashSet;

public class RemoveDuplicate {

    public Node remove(CustomLinkedList linkedList) {
        Node tempHead = linkedList.getHead();
        Node previous = null;

        HashSet<Node> map = new HashSet<>();

        while (tempHead != null) {
            if (map.contains(tempHead)) {
                previous.setNext(tempHead.getNext());
            } else {
                map.add(tempHead);
                previous = tempHead;
            }
            tempHead = tempHead.getNext();
        }

        return linkedList.getHead();
    }
}
