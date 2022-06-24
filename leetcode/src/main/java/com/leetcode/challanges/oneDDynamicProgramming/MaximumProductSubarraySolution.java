package com.leetcode.challanges.oneDDynamicProgramming;

import java.util.Arrays;

/**
 * Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarraySolution {
    /**
     * Runtime O(n)
     * Space Complexity O(1)
     * */
    public static int maxProduct(int[] nums) {
        int result = Arrays.stream(nums).max().getAsInt();
        int currMin = 1;
        int currMax = 1;

        for (int n : nums) {
            int temp = n * currMax;
            currMax = Math.max(Math.max(n * currMax, n * currMin), n);
            currMin = Math.min(Math.min(temp,n * currMin ), n);
            result = Math.max(result,currMax);
        }
        return result;
    }
}
