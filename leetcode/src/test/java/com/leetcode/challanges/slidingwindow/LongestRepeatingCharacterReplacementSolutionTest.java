package com.leetcode.challanges.slidingwindow;

import com.leetcode.challanges.arrays_hashing.LongestConsecutiveSequenceSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementSolutionTest {

    @Test
    void characterReplacementTest1() {
        int actual = LongestRepeatingCharacterReplacementSolution.characterReplacement("AABABBA", 1);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void characterReplacementTest2() {
        int actual = LongestRepeatingCharacterReplacementSolution.characterReplacement("ABAB", 2);
        Assertions.assertEquals(4, actual);
    }
}