package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsSolutionTest {

    @Test
    void topKFrequentTest1() {
        int[] actual = TopKFrequentElementsSolution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Assertions.assertArrayEquals(new int[]{1,2} , actual);
    }

    @Test
    void topKFrequentTest2() {
        int[] actual = TopKFrequentElementsSolution.topKFrequent(new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1} , actual);
    }
}