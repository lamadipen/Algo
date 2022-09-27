package com.leetcode.challanges.arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * https://www.youtube.com/watch?v=3OamzN90kPg&feature=youtu.be
 *
 * */
public class ContainsDuplicateSolution {

    /** Runtime O(n^2)
     * Space Complexity O(1)
     * */
    public static boolean containsDuplicateBruteForce(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                   return  true;
                }
            }
        }
        return false;
    }

    /** Runtime O(n)
     * Space Complexity O(n)
     * */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> itemCount = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (itemCount.contains(nums[i])) {
                return true;
            }
            itemCount.add(nums[i]);
        }
        return false;
    }

}
