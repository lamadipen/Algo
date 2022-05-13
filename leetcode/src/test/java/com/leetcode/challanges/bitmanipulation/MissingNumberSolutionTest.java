package com.leetcode.challanges.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberSolutionTest {

    @Test
    void missingNumberTest1() {
        int actual = MissingNumberSolution.missingNumberOptimized(new int[]{3, 0, 1});
        Assertions.assertEquals(2,actual);
    }

    @Test
    void missingNumberTest2() {
        int actual = MissingNumberSolution.missingNumberOptimized(new int[]{0,1});
        Assertions.assertEquals(2,actual);
    }

    @Test
    void missingNumberTest3() {
        int actual = MissingNumberSolution.missingNumberOptimized(new int[]{9,6,4,2,3,5,7,0,1});
        Assertions.assertEquals(8,actual);
    }


    @Test
    void missingNumberTest4() {
        int actual = MissingNumberSolution.missingNumberXOR(new int[]{3, 0, 1});
        Assertions.assertEquals(2,actual);
    }

    @Test
    void missingNumberTest5() {
        int actual = MissingNumberSolution.missingNumberXOR(new int[]{0,1});
        Assertions.assertEquals(2,actual);
    }

    @Test
    void missingNumberTest6() {
        int actual = MissingNumberSolution.missingNumberXOR(new int[]{9,6,4,2,3,5,7,0,1});
        Assertions.assertEquals(8,actual);
    }
}