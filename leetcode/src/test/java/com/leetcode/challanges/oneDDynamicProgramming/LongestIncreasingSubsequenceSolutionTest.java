package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceSolutionTest {

    @Test
    void lengthOfLISTest1() {
        int actual = LongestIncreasingSubsequenceSolution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assertions.assertEquals(4,actual);
    }

    @Test
    void lengthOfLISTest2() {
        int actual = LongestIncreasingSubsequenceSolution.lengthOfLIS(new int[]{0,1,0,3,2,3});
        Assertions.assertEquals(4,actual);
    }

    @Test
    void lengthOfLISTest3() {
        int actual = LongestIncreasingSubsequenceSolution.lengthOfLIS(new int[]{7,7,7,7,7,7,7});
        Assertions.assertEquals(1,actual);
    }
}