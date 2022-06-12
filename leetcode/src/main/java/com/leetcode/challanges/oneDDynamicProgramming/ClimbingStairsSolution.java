package com.leetcode.challanges.oneDDynamicProgramming;
/**
 * Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * */
public class ClimbingStairsSolution {
    /**
     * DP Bottomup solution
     * Runtime O(n)
     * Space complexity O(1)
     * */
    public static int climbStairs(int n) {
        int one = 1;
        int two =1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
             one = one + two;
            two = temp;
        }
        return one;
    }
}
