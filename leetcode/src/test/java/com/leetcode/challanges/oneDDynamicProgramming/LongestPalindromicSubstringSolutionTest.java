package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringSolutionTest {
    @Test
    public void longestPalindromeTest1() {
        String actual = LongestPalindromicSubstringSolution.longestPalindrome("babad");
        Assertions.assertEquals("bab",actual);
    }

    @Test
    public void longestPalindromeTest2() {
        String actual = LongestPalindromicSubstringSolution.longestPalindrome("cbbd");
        Assertions.assertEquals("bb",actual);
    }

}