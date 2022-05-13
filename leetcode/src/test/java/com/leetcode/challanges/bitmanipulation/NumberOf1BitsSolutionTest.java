package com.leetcode.challanges.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1BitsSolutionTest {

    @Test
    void hammingWeightTest1() {
        int actual = NumberOf1BitsSolution.hammingWeight(00000000000000000000000000001011);
        Assertions.assertEquals(3,actual);
    }

    @Test
    void hammingWeightTest2() {
        int actual = NumberOf1BitsSolution.hammingWeight(00000000000000000000000010000000);
        Assertions.assertEquals(1,actual);
    }


    @Test
    void hammingWeightTest3() {
        int x1 = 0000000000000000000000000101010;
        int oncOccurance =0;
        while (x1 != 0) {
            oncOccurance += x1%2;
            x1 = x1 >>1;
        }
        System.out.println(oncOccurance);
    }
}