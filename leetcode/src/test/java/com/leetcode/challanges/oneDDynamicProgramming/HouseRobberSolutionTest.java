package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberSolutionTest {

    @Test
    void robTest1() {
        int actual = HouseRobberSolution.rob(new int[]{1,2,3,1});
        Assertions.assertEquals(4,actual);
    }

    @Test
    void robTest2() {
        int actual = HouseRobberSolution.rob(new int[]{2,7,9,3,1});
        Assertions.assertEquals(12,actual);
    }
}