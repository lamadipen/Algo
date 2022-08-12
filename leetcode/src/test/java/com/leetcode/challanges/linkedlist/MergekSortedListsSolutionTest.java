package com.leetcode.challanges.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MergekSortedListsSolutionTest {

    @Test
    void mergeKListsTest1() {
        ListNode node5 = new ListNode(5);
        ListNode node4a= new ListNode(4, node5);
        ListNode node1a = new ListNode(1,node4a);

        ListNode node4b = new ListNode(4);
        ListNode node3= new ListNode(3, node4b);
        ListNode node1b = new ListNode(1,node3);

        ListNode node6 = new ListNode(6);
        ListNode node2 = new ListNode(2,node6);

        ListNode[] lists = new ListNode[]{node1a, node1b, node2};
        ListNode actual = MergekSortedListsSolution.mergeKLists(lists);
        Assertions.assertNotNull(actual);
    }


    @Test
    void mergeKListsTest2() {
        ListNode[] lists = new ListNode[]{};
        ListNode actual = MergekSortedListsSolution.mergeKLists(lists);
        Assertions.assertNull(actual);
    }


    @Test
    void mergeKListsTest3() {
        ListNode[] lists = new ListNode[]{null};
        ListNode actual = MergekSortedListsSolution.mergeKLists(lists);
        Assertions.assertNull(actual);
    }
}