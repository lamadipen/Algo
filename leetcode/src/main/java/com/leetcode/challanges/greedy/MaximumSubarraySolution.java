package com.leetcode.challanges.greedy;
/**
 * Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * */
public class MaximumSubarraySolution {
    /**
     * Runtime O(n)
     * */
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int maxSum = nums[0];
        int currentSum =0;

        for (int i=0; i < nums.length;i++){
            if(currentSum < 0){
                currentSum =0;
            }
            currentSum +=nums[i];
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
