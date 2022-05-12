package com.leetcode.challanges.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListCycleSolutionTest {

    @Test
    void hasCycleTest1() {
        boolean actual = LinkedListCycleSolution.hasCycleOptimized(buildHead1());
        Assertions.assertTrue(actual);
    }


    @Test
    void hasCycleTest2() {
        boolean actual = LinkedListCycleSolution.hasCycleOptimized(buildHead2());
        Assertions.assertTrue(actual);
    }

    @Test
    void hasCycleTest3() {
        boolean actual = LinkedListCycleSolution.hasCycleOptimized(buildHead3());
        Assertions.assertFalse(actual);
    }


    @Test
    void hasCycleTest4() {
        boolean actual = LinkedListCycleSolution.hasCycle(buildHead1());
        Assertions.assertTrue(actual);
    }


    @Test
    void hasCycleTest5() {
        boolean actual = LinkedListCycleSolution.hasCycle(buildHead2());
        Assertions.assertTrue(actual);
    }

    @Test
    void hasCycleTest6() {
        boolean actual = LinkedListCycleSolution.hasCycle(buildHead3());
        Assertions.assertFalse(actual);
    }


    private ListNode buildHead1() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(0,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(3,node2);
        node4.next = node2;
        return head;
    }

    private ListNode buildHead2() {
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(1,node2);
        node2.next = head;
        return head;
    }

    private ListNode buildHead3() {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(3,node3);
        ListNode head = new ListNode(1,node2);
        return head;
    }
}