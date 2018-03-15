package hrank.DataStructure.LinkedList.DeleteaNode;

import hrank.DataStructure.LinkedList.Node;

/**
 * Created by dipen on 3/7/2018.
 */
public class Sloution {

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
        Delete(head,3);

        while(head.next!=null){
            System.out.print(head.data);
            head = head.next;
        }
        System.out.print(head.data);
    }

    static Node Delete(Node head, int position) {
        Node rootNode = head;
        if(head == null){
            return  head;
        }
        if(head.next == null && position == 0){
            head = null;
            return head;
        }
        if(head.next != null && position == 0){
            head = head.next;
            return head;
        }

        int counter = 0;

        while(head.next != null && counter < position -1){
            head = head.next;
            counter++;
        }

        head.next = head.next.next;
        return rootNode;
    }
}
