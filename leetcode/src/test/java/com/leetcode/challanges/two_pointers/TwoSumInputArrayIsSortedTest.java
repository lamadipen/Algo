package com.leetcode.challanges.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumInputArrayIsSortedTest {

    @Test
    void twoSumTest1() {
        int[] actual = TwoSumInputArrayIsSorted.twoSum(new int[]{2,7,11,15},9);
        Assertions.assertEquals(1,actual[0]);
        Assertions.assertEquals(2,actual[1]);
    }

    @Test
    void twoSumTest2() {
        int[] actual = TwoSumInputArrayIsSorted.twoSum(new int[]{2,3,4},6);
        Assertions.assertEquals(1,actual[0]);
        Assertions.assertEquals(3,actual[1]);
    }

    @Test
    void twoSumTest3() {
        int[] actual = TwoSumInputArrayIsSorted.twoSum(new int[]{-1,0},-1);
        Assertions.assertEquals(1,actual[0]);
        Assertions.assertEquals(2,actual[1]);
    }
}