package com.leetcode.challanges.intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsSolutionTest {

    @Test
    void merge() {
        int[][] actual = MergeIntervalsSolution.merge(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}});

    }
}