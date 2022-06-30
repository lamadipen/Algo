package com.leetcode.challanges.oneDDynamicProgramming;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * */
public class LongestIncreasingSubsequenceSolution {

    /**
     * Runtime O(n^2)
     * SpaceComplexity O(n)
     * */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxTillNow =1;

        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (j < i) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
                }
                j++;
            }
            maxTillNow = Math.max(maxTillNow, dp[i]);
        }

        return maxTillNow;
    }

}
