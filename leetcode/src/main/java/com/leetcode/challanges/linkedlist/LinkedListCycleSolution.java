package com.leetcode.challanges.linkedlist;

import java.util.HashSet;

/**
 * Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * */
public class LinkedListCycleSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(1)
     * */
    public static boolean hasCycleOptimized(ListNode head) {
        ListNode slowHead = head;
        ListNode fastHead = head.next;

        while (slowHead != null && fastHead != null) {
            if (slowHead.equals(fastHead)) {
                return true;
            }
            slowHead = slowHead.next;
            fastHead = fastHead.next.next;
        }

        return false;
    }


    /**
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
