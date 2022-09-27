package com.leetcode.challanges.twoDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceSolutionTest {

    @Test
    void longestCommonSubsequenceTest1() {
        int actual = LongestCommonSubsequenceSolution.longestCommonSubsequence("abcde", "ace");
        Assertions.assertEquals(3,actual);
    }


    @Test
    void longestCommonSubsequenceTest2() {
        int actual = LongestCommonSubsequenceSolution.longestCommonSubsequence("abc", "abc");
        Assertions.assertEquals(3,actual);
    }

    @Test
    void longestCommonSubsequenceTest3() {
        int actual = LongestCommonSubsequenceSolution.longestCommonSubsequence("abc", "def");
        Assertions.assertEquals(0,actual);
    }
}