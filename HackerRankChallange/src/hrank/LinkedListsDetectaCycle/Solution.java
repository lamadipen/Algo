package hrank.LinkedListsDetectaCycle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dipen on 5/9/2017.
 */
public class Solution {

    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

    /**
     boolean hasCycle(Node head) {
     if (head == null) return false;

     Node slow = head;
     Node fast = head.next;
     while (slow != fast) {
     if (fast == null || fast.next == null) return false;

     slow = slow.next;
     fast = fast.next.next;
     }

     return true;
     }
     **/
    boolean hasCycle(Node head) {
        Map<Node,Integer> checkMap = new HashMap();
        if(head == null) return false;

        while(head.next != null)
        {
            if(!checkMap.containsKey(head))
            {
                checkMap.put(head,head.data);
            }
            else
            {
                return true;
            }
            head = head.next;

        }
        return false;
    }

}

class Node {
    int data;
    Node next;
}


