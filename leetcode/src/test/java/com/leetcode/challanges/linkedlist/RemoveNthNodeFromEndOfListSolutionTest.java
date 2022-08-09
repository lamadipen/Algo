package com.leetcode.challanges.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfListSolutionTest {

    @Test
    void removeNthFromEndTest1() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode actual = RemoveNthNodeFromEndOfListSolution.removeNthFromEnd(node1,2);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1,actual.val);
        Assertions.assertEquals(2,actual.next.val);
        Assertions.assertEquals(3,actual.next.next.val);
        Assertions.assertEquals(5,actual.next.next.next.val);
    }
}