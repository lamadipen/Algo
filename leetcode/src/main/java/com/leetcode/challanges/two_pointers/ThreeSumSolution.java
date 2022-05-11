package com.leetcode.challanges.two_pointers;

import java.util.*;

/**
 * 3Sum
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSumSolution {

    /**
     * Runtime O(n^3)
     * Space Complexity O(n + n)
     */
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visted = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer[] ints = {nums[i], nums[j], nums[k]};

                        List<Integer> list = Arrays.asList(ints);
                        if (!visted.containsAll(list)) {
                            result.add(list);
                        }
                        visted.addAll(list);
                    }
                }
            }
        }
        return result;
    }


    /**
     * Runtime O(n^2)
     * Space Complexity O(n) as sorting algorithm may use extra space
     */
    public static List<List<Integer>> threeSumBruteForceOptimized(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i + 1])) {
                int target = 0 - nums[i];
                int left = 0;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[left]);
                        subList.add(nums[right]);
                        result.add(subList);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

}
