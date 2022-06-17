package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysSolutionTest {

    @Test
    void numDecodingsTest1() {
        int actual = DecodeWaysSolution.numDecodings("12");
        Assertions.assertEquals(2,actual);
    }

    @Test
    void numDecodingsTest2() {
        int actual = DecodeWaysSolution.numDecodings("226");
        Assertions.assertEquals(3,actual);
    }

    @Test
    void numDecodingsTest3() {
        int actual = DecodeWaysSolution.numDecodings("06");
        Assertions.assertEquals(0,actual);
    }

    @Test
    void numDecodingsTest4() {
        int actual = DecodeWaysSolution.numDecodings("12131");
        Assertions.assertEquals(5,actual);
    }
}