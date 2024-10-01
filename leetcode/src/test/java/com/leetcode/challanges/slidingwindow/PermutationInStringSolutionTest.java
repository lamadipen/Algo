package com.leetcode.challanges.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PermutationInStringSolutionTest {
    @Test
    void checkInclusionTest1() {
        boolean actual = PermutationInStringSolution.checkInclusion("ab", "eidbaooo");
        Assertions.assertTrue(actual);
    }

    @Test
    void checkInclusionTest2() {
        boolean actual = PermutationInStringSolution.checkInclusion("ab", "eidboaoo");
        Assertions.assertTrue(actual);
    }
}