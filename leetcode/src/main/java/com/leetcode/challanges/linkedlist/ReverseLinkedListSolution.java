package com.leetcode.challanges.linkedlist;

import java.util.List;
import java.util.Stack;

/**
 * Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * https://www.youtube.com/watch?v=G0_I-ZF0S38
 * */
public class ReverseLinkedListSolution {
    /**
     * Runtime O(n)
     * Space O(n)
     * */
    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode reversedHead = stack.pop();
        ListNode tempHead = reversedHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = null;
            tempHead.next = node;
            tempHead = tempHead.next;
        }
        return reversedHead;
    }


    /**
     * Runtime O(n)
     * Space O(1)
     * */
    public static ListNode reverseListOptimized(ListNode head) {
        if(head == null) return head;
        ListNode previous =null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }


    /**
     * Runtime O(n)
     * Space O(1)
     * */
    public static ListNode reverseListOptimizedRecursive(ListNode head) {
        if(head == null) return head;
        ListNode previous =null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}
