package com.leetcode.challanges.oneDDynamicProgramming;
/**
 * Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 * */
public class PalindromicSubstringsSolution {
    /**
     * Runtime O(n)
     * */
    public static int countSubstrings(String s) {
        int result =0;

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            int left =i;
            int right = i;

            //odd palindrom
            while (left >= 0 && right < sLength && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }

            left=i;
            right=i+1;
            //even palindrom
            while (left >= 0 && right < sLength && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }

        }
        return result;
    }
}
