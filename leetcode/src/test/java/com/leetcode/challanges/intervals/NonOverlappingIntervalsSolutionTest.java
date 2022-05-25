package com.leetcode.challanges.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsSolutionTest {

    @Test
    void eraseOverlapIntervalsTest1() {
        int actual = NonOverlappingIntervalsSolution.eraseOverlapIntervals(new int[][]{new int[]{1,2},new int[]{2,3}, new int[]{3, 4}, new int[]{1,3} });
        Assertions.assertEquals(1,actual);
    }

    @Test
    void eraseOverlapIntervalsTest2() {
        int actual = NonOverlappingIntervalsSolution.eraseOverlapIntervals(new int[][]{new int[]{1,2},new int[]{1,2}, new int[]{1, 2} });
        Assertions.assertEquals(2,actual);
    }

    @Test
    void eraseOverlapIntervalsTest3() {
        int actual = NonOverlappingIntervalsSolution.eraseOverlapIntervals(new int[][]{new int[]{1,2},new int[]{2,3} });
        Assertions.assertEquals(0,actual);
    }
}
