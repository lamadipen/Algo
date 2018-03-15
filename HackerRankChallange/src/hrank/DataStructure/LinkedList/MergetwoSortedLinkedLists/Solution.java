package hrank.DataStructure.LinkedList.MergetwoSortedLinkedLists;

import hrank.DataStructure.LinkedList.Node;

/**
 * Created by dipen on 3/13/2018.
 */
public class Solution {
    public static void main(String[] args) {
        Node head1 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        head1.next = node1;
        head1.data = 1;
        node1.next = node2;
        //node1.next =null;
        node1.data = 3;
        node2.data = 5;
        node2.next = null;
        // node2.next = node3;
       // node3.data = 10;
       // node3.next = null;

        Node head2 = new Node();
        Node nodeb1 = new Node();
        Node nodeb2 = new Node();
        Node nodeb3 = new Node();

        head2.next = nodeb1;
        head2.data = 2;
        //nodeb1.next = null;
        //nodeb1.next = node2;
        nodeb1.next = null;
        nodeb1.data = 4;
        nodeb2.data = 7;
        nodeb2.next = node3;
        nodeb3.data = 11;
        nodeb3.next = null;

        Node returnedList = mergeLists(head1,head2);

       /* while (returnedList.next != null){
            System.out.println(returnedList.data);
            returnedList = returnedList.next;
        }*/
        //System.out.println(returnedList.data);

    }

    public static Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if(headA == null && headB == null){
            return null;
        }
        if(headA == null){
            return headB;
        }
        if(headB == null ){
            return headA;
        }

        if(headA.data < headB.data ){
            headA.next = mergeLists(headA.next,headB);
            return headA;
        }else{
            headB.next = mergeLists(headA,headB.next);
            return  headB;
        }
    }


}
