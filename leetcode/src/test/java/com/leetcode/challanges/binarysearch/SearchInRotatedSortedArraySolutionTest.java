package com.leetcode.challanges.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArraySolutionTest {

    @Test
    void searchTest1() {
        int actual = SearchInRotatedSortedArraySolution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        Assertions.assertEquals(4,actual);
    }


    @Test
    void searchTest2() {
        int actual = SearchInRotatedSortedArraySolution.search(new int[]{4,5,6,7,0,1,2}, 3);
        Assertions.assertEquals(-1,actual);
    }

    @Test
    void searchTest3() {
        int actual = SearchInRotatedSortedArraySolution.search(new int[]{1}, 0);
        Assertions.assertEquals(-1,actual);
    }
}