package hrank.DataStructure.LinkedList.Reversealinkedlist;

import hrank.DataStructure.LinkedList.Node;

import java.util.Stack;

/**
 * Created by dipen on 3/7/2018.
 */
public class Solution {

    static Node Reverse(Node head) {
        if(head==null){
            return null;
        }else{
            Stack<Node> nodes = new Stack<>();

            while (head.next != null){
                nodes.add(head);
                head = head.next;
            }
            nodes.add(head);
            Node newRoot = nodes.pop();
            Node newHead = newRoot;
            while (!nodes.empty()){
                Node newNode = new Node();
                Node fromStack = nodes.pop();
                newNode.data = fromStack.data;
                newRoot.next = newNode;
                newRoot = newNode;
            }

            return newHead;
        }

    }

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
        Node result = Reverse(head);
        while (result.next != null){
            System.out.println(result.data);
            result = result.next;
        }
        System.out.println(result.data);

        /**https://www.hackerrank.com/challenges/reverse-a-linked-list/forum **/
    }

}
