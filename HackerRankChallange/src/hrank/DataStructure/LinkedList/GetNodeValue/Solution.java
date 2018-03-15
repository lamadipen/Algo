package hrank.DataStructure.LinkedList.GetNodeValue;

import hrank.DataStructure.LinkedList.Node;

import java.util.Stack;

/**
 * Created by dipen on 3/14/2018.
 * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 */
public class Solution {
    public static void main(String[] args) {
        Node head = Node.getNodeInstance();
        System.out.println(GetNode(head,1));
    }

    static int GetNode(Node head, int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Stack<Node> reversed = new Stack<>();

        while (head.next != null){
            reversed.add(head);
            head = head.next;
        }
        reversed.add(head);

        head = reversed.pop();

        while (!reversed.empty()){
            Node temp = reversed.pop();
            head.next = temp;
            head = temp;
        }
        int counter =0;
        int requiredValue = 0;
        while (head.next != null || counter == n){
            if(counter == n){
                requiredValue = head.data;
                break;
            }
            head = head.next;
            counter++;
        }

        return requiredValue;
    }
}
