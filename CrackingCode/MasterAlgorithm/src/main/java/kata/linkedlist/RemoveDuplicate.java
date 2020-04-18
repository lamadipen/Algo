package kata.linkedlist;

import java.util.HashMap;

public class RemoveDuplicate {

    public Node remove(CustomLinkedList linkedList) {
        Node tempHead = linkedList.getHead();
        Node head = linkedList.getHead();

        HashMap<Node, Node> map = new HashMap<>();

        while (tempHead != null) {
            if (map.containsKey(tempHead)) {

            } else {
                map.put(tempHead, tempHead);
            }
            tempHead = tempHead.getNext();
        }

        
        return null;
    }
}
