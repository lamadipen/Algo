package com.leetcode.challanges.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumofTwoIntegersSolutionTest {

    @Test
    void getSumTest1() {
        int actual = SumofTwoIntegersSolution.getSum(1, 2);
        Assertions.assertEquals(3,actual);
    }

    @Test
    void getSumTest2    () {
        int actual = SumofTwoIntegersSolution.getSum(2, 3);
        Assertions.assertEquals(5,actual);
    }
}