package com.dp.leetcode;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstParam = l1;
        ListNode secondParam = l2;
//        Stack<Integer> firstNumStack = new Stack<>();
//        Stack<Integer> secondNumStack = new Stack<>();
//
//        while(firstParam.next != null){
//            firstNumStack.push(firstParam.val);
//            firstParam = firstParam.next;
//        }
//
//        while(l2.next != null){
//            secondNumStack.push(secondParam.val);
//            secondParam = secondParam.next;
//        }

        StringBuffer firstNum = new StringBuffer();
        while (firstParam != null) {
            System.out.println(firstParam.val);
            firstNum.append(firstParam.val);
            firstParam = firstParam.next;
        }
        String s1 = firstNum.reverse().toString();


        StringBuffer secondNum = new StringBuffer();
        while (secondParam != null) {
            System.out.println(secondParam.val);
            secondNum.append(secondParam.val);
            secondParam = secondParam.next;
        }
        String s2 = secondNum.reverse().toString();

        Integer result = Integer.valueOf(s1) + Integer.valueOf(s2);
        StringBuffer sb = new StringBuffer(result.toString());
        char[] chars = sb.reverse().toString().toCharArray();
        System.out.println(chars.length);

        ListNode returnList = new ListNode(Integer.valueOf(chars[0]+""));
        ListNode curent = returnList;

        for (int i=1; i < chars.length; i++) {
            //System.out.println(chars[i]);
            String sq = chars[i]+"";
            ListNode newNode = new ListNode(Integer.valueOf(sq));
            curent.next = newNode;
            curent = curent.next;

        }

        return returnList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1C1 = new ListNode(4);
        ListNode l1C1GC1 = new ListNode(3);
        l1.next = l1C1;
        l1C1.next = l1C1GC1;

        ListNode l2 = new ListNode(5);
        ListNode l2C1 = new ListNode(6);
        ListNode l2C1GC1 = new ListNode(4);
        l2.next = l2C1;
        l2C1.next = l2C1GC1;

        ListNode listNode = addTwoNumbersLeetCodeSolution(l1, l2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbersLeetCodeSolution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;

        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}