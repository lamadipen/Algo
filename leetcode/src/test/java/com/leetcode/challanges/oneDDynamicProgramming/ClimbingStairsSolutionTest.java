package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsSolutionTest {

    @Test
    void climbStairsTest1() {
        int actual = ClimbingStairsSolution.climbStairs(2);
        Assertions.assertEquals(2,actual);
    }

    @Test
    void climbStairsTest2() {
        int actual = ClimbingStairsSolution.climbStairs(3);
        Assertions.assertEquals(3,actual);
    }
}