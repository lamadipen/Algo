package hrank.DataStructure.LinkedList.FindMergePointofTwoLists;

import hrank.DataStructure.LinkedList.Node;

/**
 * Created by dipen on 3/16/2018.
 */
public class Solution {

    public static void main(String[] args) {
        Node head1 = new Node();
        head1.data =3;
        Node h1node1 = new Node();
        h1node1.data =2;
        Node h1node2 = new Node();
        h1node1.data =1;


        Node head2 = new Node();
        Node h2node1 = new Node();
        h1node1.data =4;
        Node h2node2 = new Node();
        h1node1.data =5;

        Node common = new Node();
        common.data =2;
        common.next = null;

        head1.next = h1node1;
        h1node1.next = common;

        h2node2.next = common;
        head2.next = h2node1;
        h2node1.next = h2node2;
        h2node2.next = common;

        System.out.println(FindMergeNode(head1,head2));

    }

    static int FindMergeNode(Node headA, Node headB) {
        Node currentHeadA = headA;
        Node currentHeadB = headB;

        while (currentHeadA != currentHeadB){
            if(currentHeadA.next == null){
                currentHeadA = headB;
            }else{
                currentHeadA = currentHeadA.next;
            }
            if(currentHeadB.next == null){
                currentHeadB = headA;
            }else{
                currentHeadB = currentHeadB.next;
            }
        }
        return currentHeadB.data;
    }


}
