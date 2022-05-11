package com.leetcode.challanges.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * */
public class LongestSubstringWithoutRepeatingCharactersSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public static int findLengthOfLongestRepeatingCharacters(String s) {
        if(s.length() == 0 ) return 0;
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int left =0;
        int right =0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}
