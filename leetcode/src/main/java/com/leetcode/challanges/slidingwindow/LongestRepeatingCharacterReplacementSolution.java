package com.leetcode.challanges.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * https://www.youtube.com/watch?v=gqXU1UyA8pk
 */
public class LongestRepeatingCharacterReplacementSolution {
    /**
     * Runtime  O(26*n) ~ O(n)
     * SpaceComplexity O(n)
     *
     * */
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int result =0;

        int windowStart =0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);
            charCount.put(endChar, charCount.getOrDefault(endChar, 0) + 1);

            while ((windowEnd - windowStart + 1) - Collections.max(charCount.values()) > k) {
                char starChar = s.charAt(windowStart);
                charCount.put(starChar, charCount.getOrDefault(starChar,0)-1);
                windowStart = windowStart +1;
            }
            result = Math.max(result,windowEnd- windowStart +1);
        }

        return result;
    }
}
