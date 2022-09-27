package com.leetcode.challanges.bitmanipulation;
/**
 * Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * https://www.youtube.com/watch?v=WnPLSRLSANE&feature=youtu.be
 * */
public class MissingNumberSolution {
/**
 *  Runtime O(n)
 *  Space Complexity O(1)
 *  */
    public static int missingNumberOptimized(int[] nums) {
        int actualTotal = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return actualTotal -sum;
    }


    /**
     * Runtime O(n)
     * SpaceComplexity O(1)
     *
     * */
    public static int missingNumber(int[] nums) {
        int actualTotal = 0;
        for (int i = 0; i <= nums.length; i++) {
            actualTotal += i;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return actualTotal -sum;
    }


    /**
     * Runtime O(n)
     * SpaceComplexity O(1)
     *
     * */
    public static int missingNumberXOR(int[] nums) {
        int actualTotal = nums.length;
        for (int i = 0; i < nums.length; i++) {
            actualTotal ^= i ^ nums[i];
        }

        return actualTotal;
    }
}
