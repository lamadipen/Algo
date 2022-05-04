package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductOfArrayExceptSelfSolutionTest {

    @Test
    void productExceptSelfTest1() {
        int[] actual = ProductOfArrayExceptSelfSolution.productExceptSelf(new int[]{1,2,3,4});
        Assertions.assertArrayEquals(new int[]{24,12,8,6},actual);
    }

    @Test
    void productExceptSelfTest2() {
        int[] actual = ProductOfArrayExceptSelfSolution.productExceptSelf(new int[]{-1,1,0,-3,3});
        Assertions.assertArrayEquals(new int[]{0,0,9,0,0},actual);
    }


    @Test
    void productExceptSelfTest3() {
        int[] actual = ProductOfArrayExceptSelfSolution.productExceptSelfOptimized(new int[]{1,2,3,4});
        Assertions.assertArrayEquals(new int[]{24,12,8,6},actual);
    }

    @Test
    void productExceptSelfTest4() {
        int[] actual = ProductOfArrayExceptSelfSolution.productExceptSelfOptimized(new int[]{-1,1,0,-3,3});
        Assertions.assertArrayEquals(new int[]{0,0,9,0,0},actual);
    }
}