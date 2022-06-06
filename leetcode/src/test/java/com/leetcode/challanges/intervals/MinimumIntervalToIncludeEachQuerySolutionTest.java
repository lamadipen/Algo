package com.leetcode.challanges.intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinimumIntervalToIncludeEachQuerySolutionTest {

    @Test
    void minIntervalTest1() {
        int[] minInterval = MinimumIntervalToIncludeEachQuerySolution.minInterval(new int[][]{new int[]{1,4},new int[]{2,4}, new int[]{3,6}, new int[]{4,4} }, new int[]{2,3,4,5});
        System.out.println("minInterval = " + Arrays.toString(minInterval));
    }

    @Test
    void minIntervalTest2() {
        int[] minInterval = MinimumIntervalToIncludeEachQuerySolution.minInterval(new int[][]{new int[]{2,3},new int[]{2,5}, new int[]{1,8}, new int[]{20,25} }, new int[]{2,19,5,22});
        System.out.println("minInterval = " + Arrays.toString(minInterval));
    }
}