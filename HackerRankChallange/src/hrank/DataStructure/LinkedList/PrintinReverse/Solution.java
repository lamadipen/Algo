package hrank.DataStructure.LinkedList.PrintinReverse;

import  hrank.DataStructure.LinkedList.Node;

import java.util.Stack;

/**
 * Created by dipen on 3/7/2018.
 */
public class Solution {

    public static void main(String[] args) {
        Node head = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        head.next = node1;
        head.data = 2;
        node1.next = node2;
        node1.data = 5;
        node2.data = 9;
        node2.next = node3;
        node3.data = 20;
        node3.next = null;
        ReversePrint(head);
    }


    static void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head != null){
            Stack<Integer> reverseValue = new Stack<>();

            while (head.next != null){
                reverseValue.add(head.data);
                head = head.next;
            }
            reverseValue.add(head.data);

            while (!reverseValue.isEmpty()){
                System.out.println(reverseValue.pop());
            }

        }
        /** Recurshive solution
         if (head != null) {
         ReversePrint(head.next);
         System.out.println(head.data);
         }
         */

    }
}
