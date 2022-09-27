package com.leetcode.challanges.oneDDynamicProgramming;

/**
 * House Robber
 * https://leetcode.com/problems/house-robber/
 * Pattern: Top-Down Dynamic Programming
 *
 * https://www.youtube.com/watch?v=73r3KWiEvyk
 */
public class HouseRobberSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(1)
     * */
    public static int rob(int[] nums) {
        int choice1 = 0;
        int choice2 = 0;

        for (int n: nums) {
            int temp = Math.max(choice1+n, choice2);
            choice1 = choice2;
            choice2 = temp;
        }
        return choice2;
    }
}
