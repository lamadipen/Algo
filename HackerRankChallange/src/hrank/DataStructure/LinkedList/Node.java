package hrank.DataStructure.LinkedList;

/**
 * Created by dipen on 3/7/2018.
 */
public class Node{
    public int data;
    public Node next;


    public static Node getNodeInstance(){
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

        return head;
    }
}