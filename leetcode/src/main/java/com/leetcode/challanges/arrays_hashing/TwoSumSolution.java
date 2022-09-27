package com.leetcode.challanges.arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * https://www.youtube.com/watch?v=KLlXCFG5TnA
 * */
public class TwoSumSolution {

    /**
     * Runtime O(n^2)
     * Space Complexity O(1) to define sum of the two values
     * */
    public static int[] twoSumBruteForce(int[] nums, int target) {

        for (int i =0;i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Runtime O(n)
     * Space Complexity O(n) where n is input array size
     * */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];

            if (valueIndexMap.containsKey(delta)) {
                return new int[]{valueIndexMap.get(delta),i };
            }
            valueIndexMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
