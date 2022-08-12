package com.leetcode.challanges.linkedlist;
/**
 * Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * https://www.youtube.com/watch?v=q5a5OiGbT6Q
 * */
public class MergekSortedListsSolution {
    /**
     * Solution using Iterative Merge Sort
     * Time Complexity:         O(n*log(k))
     * Extra Space Complexity:  O(1)
     * */
    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;

        while (interval < size) {
            for (int i = 0; i < size - interval; i+=2* interval) {
                lists[i] = merge(lists[i], lists[i + interval]);

            }
            interval *= 2;
        }

        return size > 0 ? lists[0]: null;
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }else{
            current.next = list2;
        }
        return dummy.next;
    }
}
