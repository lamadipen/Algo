package hrank.DataStructure.LinkedList.DeleteDuplicateValueNodesFromSortedLinkedlist;

import hrank.DataStructure.LinkedList.Node;

/**
 * Created by dipen on 3/15/2018.
 */
public class Solution {

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        Node node1 = new Node();
        node1.data = 1;
        Node node2 = new Node();
        node2.data = 1;
        Node node3 = new Node();
        node3.data =3;

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        head = RemoveDuplicates(head);

        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null) return null;
        Node result = head;
        while(head.next != null){
            if(head.next.data == head.data){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return result;
    }


    /*Recursive solution
    Node RemoveDuplicates(Node head) {
        if ( head == null ) return null;
        Node nextItem = head.next;
        while ( nextItem != null && head.data == nextItem.data ) {
            nextItem = nextItem.next;
        }
        head.next = RemoveDuplicates( nextItem );
        return head;
    }*/


}
