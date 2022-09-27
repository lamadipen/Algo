package com.leetcode.challanges.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimunWindowSubStringTest {

    @Test
    void minWindowTest1() {
        String actual = MinimunWindowSubString.minWindow2("ADOBECODEBANC", "ABC");
        Assertions.assertEquals("BANC", actual);
    }

    @Test
    void minWindowTest2() {
        String actual = MinimunWindowSubString.minWindow2("a", "a");
        Assertions.assertEquals("a", actual);
    }

    @Test
    void minWindowTeste() {
        String actual = MinimunWindowSubString.minWindow2("a", "aa");
        Assertions.assertEquals("", actual);
    }
}