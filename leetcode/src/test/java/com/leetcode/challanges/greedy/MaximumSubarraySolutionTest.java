package com.leetcode.challanges.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarraySolutionTest {

    @Test
    void maxSubArrayTest1() {
        int actual = MaximumSubarraySolution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assertions.assertEquals(6,actual);
    }


    @Test
    void maxSubArrayTest2() {
        int actual = MaximumSubarraySolution.maxSubArray(new int[]{1});
        Assertions.assertEquals(1,actual);
    }


    @Test
    void maxSubArrayTest3() {
        int actual = MaximumSubarraySolution.maxSubArray(new int[]{5,4,-1,7,8});
        Assertions.assertEquals(23,actual);
    }
}