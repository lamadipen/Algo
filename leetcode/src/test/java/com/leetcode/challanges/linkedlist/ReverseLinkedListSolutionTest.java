package com.leetcode.challanges.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListSolutionTest {

    @Test
    void reverseListTest1() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);

        ListNode actual = ReverseLinkedListSolution.reverseList(head);

        System.out.println("actual = " + actual);
        int i=5;
        while(0 < i){
            Assertions.assertEquals(i, actual.val);
            actual = actual.next;
            i--;
        }
    }

    @Test
    void reverseListTest2() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);

        ListNode actual = ReverseLinkedListSolution.reverseListOptimized(head);

        System.out.println("actual = " + actual);
        int i=5;
        while(0 < i){
            Assertions.assertEquals(i, actual.val);
            actual = actual.next;
            i--;
        }
    }
}