package hrank.DataStructure.LinkedList.CycleDetection;

import hrank.DataStructure.LinkedList.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dipen on 3/14/2018.
 */
public class Solution {
    public static void main(String[] args) {
        Node node = Node.getNodeInstance();
        Node head = node;
       /* Node temp = node.next;

        while (node.next !=null){
            node = node.next;
        }
        node.next = temp;*/
        System.out.println("Here is the reult " + hasCycle(head));
    }

    static boolean hasCycle(Node head) {
        if(head == null) {
            return false;
        }
        Set<Node> visited = new HashSet<>();
        boolean flag = false;
        while (head != null){
            if(visited.contains(head)){
                flag = true;
                break;
            }
            visited.add(head);
            head = head.next;
        }
        return flag;
    }

}
