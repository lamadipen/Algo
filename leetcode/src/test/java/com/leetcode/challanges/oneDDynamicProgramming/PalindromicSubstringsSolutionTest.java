package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringsSolutionTest {

    @Test
    void countSubstringsTest1() {
        int actual = PalindromicSubstringsSolution.countSubstrings("abc");
        Assertions.assertEquals(3,actual);
    }

    @Test
    void countSubstringsTest2() {
        int actual = PalindromicSubstringsSolution.countSubstrings("aaa");
        Assertions.assertEquals(6,actual);
    }
}