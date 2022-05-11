package com.leetcode.challanges.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterSolutionTest {

    @Test
    void maxAreaTest1() {
        int actual = ContainerWithMostWaterSolution.maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assertions.assertEquals(49,actual);
    }

    @Test
    void maxAreaTest2() {
        int actual = ContainerWithMostWaterSolution.maxAreaBruteForce(new int[]{1,1});
        Assertions.assertEquals(1,actual);
    }

    @Test
    void maxAreaTest3() {
        int actual = ContainerWithMostWaterSolution.maxAreaTwoPointer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assertions.assertEquals(49,actual);
    }

    @Test
    void maxAreaTest4() {
        int actual = ContainerWithMostWaterSolution.maxAreaTwoPointer(new int[]{1,1});
        Assertions.assertEquals(1,actual);
    }
}