package com.leetcode.challanges.oneDDynamicProgramming;
/**
 * Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * */
public class LongestPalindromicSubstringSolution {
    /**
     * Runtime O(n^2)
     *
     * */
    public static String longestPalindrome(String s) {
      String resultStr="";
      int resultLen = 0;

        int inputLength = s.length();
        for (int i = 0; i < inputLength; i++) {
            int left =i;
            int right =i;

            //odd length palindrom scenario
            while (left >= 0 && right < inputLength && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLen) {
                    resultLen = right -left +1;
                    resultStr = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while (left >= 0 && right < inputLength && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLen) {
                    resultLen = right - left +1;
                    resultStr = s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return resultStr;
    }
}
