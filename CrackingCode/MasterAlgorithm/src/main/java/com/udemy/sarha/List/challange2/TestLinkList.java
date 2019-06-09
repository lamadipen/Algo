package com.udemy.sarha.List.challange2;

public class TestLinkList {
    Node head;
    int size = 0;


    public void addToFront(int val){
        if(head == null){
            head = new Node(val);
        }else{
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void printAll() {
        Node current = head;
        System.out.print("Head->");
        while (current != null){
            System.out.print(current.value+ "->");
            current = current.next;
        }
        System.out.print(current);
        System.out.println();
    }
}


class Node{
    int value;
    Node next;

    public Node(int val){
        this.value = val;
    }
}

class Runner{
    public static void main(String[] args) {
        TestLinkList list = new TestLinkList();

        list.addToFront(12);
        list.addToFront(18);
        list.addToFront(10);
        list.addToFront(20);

        System.out.println(list.size);
        list.printAll();
        System.out.println("Head" +list.head.value);
    }
}