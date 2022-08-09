package com.leetcode.challanges.linkedlist;
/**
 * Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * */
public class RemoveNthNodeFromEndOfListSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(1)
     *
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return  null;
        ListNode dummy = new ListNode(0, head);

        ListNode left = dummy;
        ListNode right = dummy;

        while (n >= 0){
            right = right.next;
            n--;
        }

        while (right != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
