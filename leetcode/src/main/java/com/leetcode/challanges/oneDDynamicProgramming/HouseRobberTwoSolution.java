package com.leetcode.challanges.oneDDynamicProgramming;
/**
 * House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * Pattern: Top-Down Dynamic Programming
 * */
public class HouseRobberTwoSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(1)
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public static int robHelper(int[] nums, int start, int end) {
        int choice1 = 0;
        int choice2 = 0;

        for (int i = start; i <= end; i++) {
            int n = nums[i];
            int temp = Math.max(choice1 + n, choice2);
            choice1 = choice2;
            choice2 = temp;
        }
        return choice2;

    }
}
