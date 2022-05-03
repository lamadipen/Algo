package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumSolutionTest {

    @Test
    void twoSumTest1() {
        int[] actual = TwoSumSolution.twoSumBruteForce(new int[]{2,7,11,15},9);
        Assertions.assertArrayEquals(new int[]{0,1},actual);
    }

    @Test
    void twoSumTest2() {
        int[] actual = TwoSumSolution.twoSumBruteForce(new int[]{3,2,4},6);
        Assertions.assertArrayEquals(new int[]{1,2},actual);
    }

    @Test
    void twoSumTest3() {
        int[] actual = TwoSumSolution.twoSumBruteForce(new int[]{3,3},6);
        Assertions.assertArrayEquals(new int[]{0,1},actual);
    }

    @Test
    void twoSumTest4() {
        int[] actual = TwoSumSolution.twoSum(new int[]{2,7,11,15},9);
        Assertions.assertArrayEquals(new int[]{0,1},actual);
    }

    @Test
    void twoSumTest5() {
        int[] actual = TwoSumSolution.twoSum(new int[]{3,2,4},6);
        Assertions.assertArrayEquals(new int[]{1,2},actual);
    }

    @Test
    void twoSumTest6() {
        int[] actual = TwoSumSolution.twoSum(new int[]{3,3},6);
        Assertions.assertArrayEquals(new int[]{0,1},actual);
    }
}