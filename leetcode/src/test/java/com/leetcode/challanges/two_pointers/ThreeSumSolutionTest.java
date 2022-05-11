package com.leetcode.challanges.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumSolutionTest {

    @Test
    void threeSumTest1() {
        List<List<Integer>> actual = ThreeSumSolution.threeSumBruteForce(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new Integer[]{-1,0,1}));
        expected.add(Arrays.asList(new Integer[]{-1, 2, -1}));

    }

    @Test
    void threeSumTest2() {
        List<List<Integer>> actual = ThreeSumSolution.threeSumBruteForceOptimized(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new Integer[]{-1,0,1}));
        expected.add(Arrays.asList(new Integer[]{-1, 2, -1}));

    }
}