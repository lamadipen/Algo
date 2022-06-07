package com.leetcode.challanges.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchSolutionTest {

    @Test
    void searchTest1() {
        int actual = BinarySearchSolution.searchRecursive(new int[]{-1,0,3,5,9,12}, 9);
        Assertions.assertEquals(4,actual);
    }

    @Test
    void searchTest2() {
        int actual = BinarySearchSolution.searchRecursive(new int[]{-1,0,3,5,9,12}, 2);
        Assertions.assertEquals(-1,actual);
    }
}