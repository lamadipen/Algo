package hrank.MoreLinkedLists;

import java.io.*;
import java.util.*;

class Solution1 {
    public static Node removeDuplicates(Node head) {
        //Write your code here
        Node tempHead = head;
        int tempData=tempHead.data;

        if(tempHead.next == null)
        {
            return head;
        }

        while(tempHead.next.next!= null)
        {
            if(tempHead.next.data >tempHead.data)
            {
                tempHead = tempHead.next;
                if(tempHead.data == tempHead.next.data && tempHead.next.next == null)
                {
                    tempHead.next = null;
                    if(tempHead.next == null)
                    { break;}
                }
            }
            else{
                Node currentNode = tempHead;
                while(tempHead.next!=null && tempHead.next.data == currentNode.data)
                {
                    tempHead = tempHead.next;
                }
                currentNode.next = tempHead.next;
                tempHead = currentNode;
                if(tempHead.next == null)
                { break;}
                // System.out.println("Here "+ tempHead.next.data);
            }
        }
        return head;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

/** input
 6
 1
 2
 2
 3
 3
 4
 **/

/** output
 1 2 3 4
 **/