package com.leetcode.challanges.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArraySolutionTest {

    @Test
    void findMinTest1() {
        int actual = FindMinimumInRotatedSortedArraySolution.findMin(new int[]{3, 4, 5, 1, 2});
        Assertions.assertEquals(actual,1);
    }

    @Test
    void findMinTest2() {
        int actual = FindMinimumInRotatedSortedArraySolution.findMin(new int[]{4,5,6,7,0,1,2});
        Assertions.assertEquals(actual,0);
    }

    @Test
    void findMinTest3() {
        int actual = FindMinimumInRotatedSortedArraySolution.findMin(new int[]{11,13,15,17});
        Assertions.assertEquals(actual,11);
    }

    @Test
    void findMinTest4() {
        int actual = FindMinimumInRotatedSortedArraySolution.findMinShortAndSweet(new int[]{3, 4, 5, 1, 2});
        Assertions.assertEquals(1,actual);
    }

    @Test
    void findMinTest5() {
        int actual = FindMinimumInRotatedSortedArraySolution.findMinShortAndSweet(new int[]{4,5,6,7,0,1,2});
        Assertions.assertEquals(0,actual);
    }

    @Test
    void findMinTest6() {
        int actual = FindMinimumInRotatedSortedArraySolution.findMinShortAndSweet(new int[]{11,13,15,17});
        Assertions.assertEquals(11,actual);
    }
}