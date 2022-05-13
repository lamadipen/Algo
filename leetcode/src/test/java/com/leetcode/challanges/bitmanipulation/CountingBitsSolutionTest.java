package com.leetcode.challanges.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingBitsSolutionTest {

    @Test
    void countBitsTest1() {
        int[] actual = CountingBitsSolution.countBits(2);
        Assertions.assertArrayEquals(new int[]{0,1,1},actual);
    }


    @Test
    void countBitsTest2() {
        int[] actual = CountingBitsSolution.countBits(5);
        Assertions.assertArrayEquals(new int[]{0,1,1,2,1,2},actual);
    }
}