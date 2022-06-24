package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarraySolutionTest {

    @Test
    void maxProductTest1() {
        int actual = MaximumProductSubarraySolution.maxProduct(new int[]{2,3,-2,4});
        Assertions.assertEquals(6, actual);
    }

    @Test
    void maxProductTest2() {
        int actual = MaximumProductSubarraySolution.maxProduct(new int[]{-2,0,-1});
        Assertions.assertEquals(0, actual);
    }
}