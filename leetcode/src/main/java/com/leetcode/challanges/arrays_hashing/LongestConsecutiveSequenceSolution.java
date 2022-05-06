package com.leetcode.challanges.arrays_hashing;

import java.util.*;


/**
 * Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequenceSolution {

    /**
     * Runtime O(n)
     * Space complexity O(n)
     * */
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

        int longestLength = 0;

        for (int num : nums) {
            if (!map.get(num)) {
                continue;
            }
            map.put(num, false);
            int currentLength = 1;
            int left = num -1;
            int right = num + 1;

            while (map.containsKey(left)) {
                map.put(left, false);
                left--;
                currentLength++;
            }

            while (map.containsKey(right)) {
                map.put(right, false);
                right++;
                currentLength++;
            }

            longestLength = Math.max(currentLength,longestLength);
        }
        return longestLength;
    }
}
