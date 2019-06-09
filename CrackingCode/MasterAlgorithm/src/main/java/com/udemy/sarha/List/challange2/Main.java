package com.udemy.sarha.List.challange2;

public class Main {

    public static void main(String[] args) {

        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(five);
        list.printList();
        list.insertSorted(four);
        list.printList();
    }
}
