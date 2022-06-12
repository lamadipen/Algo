package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTwoSolutionTest {

    @Test
    void robTest1() {
        int actual = HouseRobberTwoSolution.rob(new int[]{2,3,2});
        Assertions.assertEquals(3,actual);
    }

    @Test
    void robTest2() {
        int actual = HouseRobberTwoSolution.rob(new int[]{1,2,3,1});
        Assertions.assertEquals(4,actual);
    }

    @Test
    void robTest3() {
        int actual = HouseRobberTwoSolution.rob(new int[]{1,2,3});
        Assertions.assertEquals(3,actual);
    }
}