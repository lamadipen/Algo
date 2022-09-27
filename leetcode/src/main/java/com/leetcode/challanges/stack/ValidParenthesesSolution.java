package com.leetcode.challanges.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  Valid Parentheses
 *  https://leetcode.com/problems/valid-parentheses/
 *
 *  https://www.youtube.com/watch?v=WTzjTskDFMg&feature=youtu.be
 * */
public class ValidParenthesesSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> closeToOpen = new HashMap();
        closeToOpen.put(')','(');
        closeToOpen.put(']','[');
        closeToOpen.put('}','{');

        for (Character c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
