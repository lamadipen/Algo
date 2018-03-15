package hrank.DataStructure.LinkedList.Insertanodeataspecificpositioninalinkedlist;

import hrank.DataStructure.LinkedList.Node;

/**
 * Created by dipen on 3/6/2018.
 */
public class Solution {

    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node rootNode = head;
        Node newHead = new Node();
        newHead.data = data;

        if(head == null){
            newHead.next = null;
            return newHead;
        }
        if(0 == position){
            newHead.next = head;
            return newHead;
        }
        int counter =0 ;
        while(head.next != null && counter < position-1){
            counter++;
            head = head.next;
        }

        Node replaceNode = head.next;
        head.next = newHead;
        newHead.next = replaceNode;

        return rootNode;

    }

}
