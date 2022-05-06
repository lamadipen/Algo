package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceSolutionTest {

    @Test
    void longestConsecutiveTest1() {
        int actual = LongestConsecutiveSequenceSolution.longestConsecutive(new int[]{100,4,200,1,3,2});
        Assertions.assertEquals(4,actual);
    }

    @Test
    void longestConsecutiveTest2() {
        int actual = LongestConsecutiveSequenceSolution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        Assertions.assertEquals(9,actual);
    }
}