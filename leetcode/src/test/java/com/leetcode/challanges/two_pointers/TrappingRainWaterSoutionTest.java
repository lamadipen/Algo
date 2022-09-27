package com.leetcode.challanges.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TrappingRainWaterSoutionTest {

    @Test
    void getTrappedRainWaterTest1() {
        int actual = TrappingRainWaterSoution.getTrappedRainWater(new int[]{7, 4, 0, 9});
        Assertions.assertEquals(10,actual);
    }

    @Test
    void getTrappedRainWaterTest2() {
        int actual = TrappingRainWaterSoution.getTrappedRainWater(new int[]{4, 2, 0, 3, 2, 5});
        Assertions.assertEquals(9,actual);
    }
}