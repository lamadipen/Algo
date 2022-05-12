package com.leetcode.challanges.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsSolutionTest {

    @Test
    void mergeTwoListsTest1() {
        ListNode actual = MergeTwoSortedListsSolution.mergeTwoLists(buildHead1(), buildHead2());
        System.out.println("actual = " + actual);
    }

    private ListNode buildHead1() {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        return head;
    }

    private ListNode buildHead2() {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(3,node3);
        ListNode head = new ListNode(1,node2);
        return head;
    }


}