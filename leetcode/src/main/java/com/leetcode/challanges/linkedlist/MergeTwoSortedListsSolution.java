package com.leetcode.challanges.linkedlist;

/**
 * Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * */
public class MergeTwoSortedListsSolution {
/**
 * Runtime O(n)
 * Space Complexity O(1)
 * */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedNode = new ListNode();
        ListNode previous = mergedNode;

        while (list1.next != null && list2.next != null) {
            if (list1.val < list2.val) {
                previous.next = list1;
                list1 = list1.next;
            } else {
                previous.next = list2;
                list2 = list2.next;
            }
            previous = previous.next;
        }
        previous.next = list1 != null ? list1 : list2;
        return mergedNode.next;
    }
}
