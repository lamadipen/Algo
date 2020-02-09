package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

 Convert Binary Number in a Linked List to Integer
 Given head which is a reference node to a singly-linked list. The value of each node in the linked list
 is either 0 or 1. The linked list holds the binary representation of a number.
 Return the decimal value of the number in the linked list.

 Example 1:
 Input: head = [1,0,1]
 Output: 5
 Explanation: (101) in base 2 = (5) in base 10

 Example 2:
 Input: head = [0]
 Output: 0
 Example 3:

 Input: head = [1]
 Output: 1
 Example 4:

 Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 Output: 18880
 Example 5:
 Input: head = [0,0]
 Output: 0
 Constraints:

 The Linked List is not empty.
 Number of nodes will not exceed 30.
 Each node's value is either 0 or 1.
 * */
public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        int base2 = 2;
        int power = 0;
        int base10 =0;
        Stack<Integer> binary = new Stack<>();

        while(head != null){
            binary.push(head.value);
            head = head.next;
        }

        while (!binary.empty()) {
            Integer temp = binary.pop();
            Integer pow = (int)Math.pow(base2, power);
            int i = temp * pow;
            power++;
            base10+=i;
        }
        return base10;
    }
    
    @Test
    public void getDecimalValueTest(){
        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(0);
        ListNode thirdNode = new ListNode(1);

        head.next = secondNode;
        secondNode.next = thirdNode;

        Assert.assertEquals(5,getDecimalValue(head));
    }

    @Test
    public void getDecimalValueTestBitwiseLeftShift(){
        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(0);
        ListNode thirdNode = new ListNode(1);

        head.next = secondNode;
        secondNode.next = thirdNode;

        Assert.assertEquals(5,getDecimalValueBitWiseLeftShift(head));
    }


    public int getDecimalValueBitWiseLeftShift(ListNode head) {
        int decimal = 0;
        while (head != null){
            System.out.println("This is one left bit shift" + (decimal<<1));
            decimal = (decimal << 1)   + head.value;
            System.out.println(decimal);
            head = head.next;
        }
        return decimal;
    }


    public int getDecimalValueWithOutStack(ListNode head) {
        int base2 = 2;
        int power = 0;
        int base10 =0;
        Stack<Integer> binary = new Stack<>();

        while(head != null){

        }
        return base10;
    }

}

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}