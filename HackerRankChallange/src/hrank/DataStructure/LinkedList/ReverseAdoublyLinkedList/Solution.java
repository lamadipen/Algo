package hrank.DataStructure.LinkedList.ReverseAdoublyLinkedList;

/**
 * Created by dipen on 3/15/2018.
 */
public class Solution {
    public static void main(String[] args) {

        Node node2 = new Node();
        node2.next = null;
        node2.data = 3;

        Node node1 = new Node();
        node1.next = node2;
        node1.data = 2;

        Node head = new Node();
        head.prev = null;
        head.next = node1;
        head.data = 1;

        node1.prev = head;
        node2.prev = node1;

        head = Reverse(head);

        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static Node Reverse(Node head) {

        if(head == null){
            return null;
        }

        while(head.next != null){
            Node newHead = head.next;
            head.next = head.prev;
            head.prev = newHead;
            head = newHead;
        }
        Node newHead = head.next;
        head.next = head.prev;
        head.prev = newHead;



        return head;
    }
}

class Node{
    int data;
    Node next;
    Node prev;
}

