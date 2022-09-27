package com.leetcode.challanges.arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * https://www.youtube.com/watch?v=9UtInBqnCgA&feature=youtu.be
 *
 * */
public class ValidAnagram {
    /** Runtime O(n + m ) where n and m are size of input string s and t
     *  Space Complexity O(n + m) where n and m are size of input string s and t
     *
     *  Another solution is to sort the string and compare each character of two string
     *  Runtime O(nlogn) as best sorting runtime is O(nlogn)
     *  Space Complexity O(n + m)
     * */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i=0; i < s.length(); i++){
            Integer charCount = sMap.getOrDefault(s.charAt(i),0);
            sMap.put(s.charAt(i), charCount + 1);
        }

        for(int i=0; i < t.length();i++){
            Integer charCount = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), charCount +1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character key = entry.getKey();
            if (tMap.getOrDefault(key, 0) != entry.getValue()) {
                return false;
            }
        }

        return  true;
    }
}
