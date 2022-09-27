package com.leetcode.challanges.twoDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniquePathsSolutionTest {

    @Test
    void uniquePathsTest1() {
        int actual = UniquePathsSolution.uniquePaths(3, 7);
        Assertions.assertEquals(28, actual);
    }

    @Test
    void uniquePathsTest2() {
        int actual = UniquePathsSolution.uniquePaths(3, 2);
        Assertions.assertEquals(3, actual);
    }
}