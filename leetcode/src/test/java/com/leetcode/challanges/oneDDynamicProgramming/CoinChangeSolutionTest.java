package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeSolutionTest {

    @Test
    void coinChangeTest1() {
        int actual = CoinChangeSolution.coinChange(new int[]{1, 2, 5}, 11);
        Assertions.assertEquals(3,actual);
    }

    @Test
    void coinChangeTest2() {
        int actual = CoinChangeSolution.coinChange(new int[]{ 2}, 3);
        Assertions.assertEquals(-1,actual);
    }

    @Test
    void coinChangeTest3() {
        int actual = CoinChangeSolution.coinChange(new int[]{1}, 0);
        Assertions.assertEquals(0,actual);
    }
}