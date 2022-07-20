package com.leetcode.challanges.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CombinationSumSolutionTest {

    @Test
    void combinationSumTest1() {
        List<List<Integer>> actual = CombinationSumSolution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        Assertions.assertEquals(2,actual.size());
        int[] result1 = actual.get(0).stream().mapToInt(i -> i).toArray();
        int[] result2 = actual.get(1).stream().mapToInt(i -> i).toArray();

        Assertions.assertArrayEquals(new int[]{2,2,3},result1);
        Assertions.assertArrayEquals(new int[]{7},result2);

    }

    @Test
    void combinationSumTest2() {
        List<List<Integer>> actual = CombinationSumSolution.combinationSum(new int[]{2,3,5}, 8);
        Assertions.assertEquals(3,actual.size());

        int[] result1 = actual.get(0).stream().mapToInt(i -> i).toArray();
        int[] result2 = actual.get(1).stream().mapToInt(i -> i).toArray();
        int[] result3 = actual.get(2).stream().mapToInt(i -> i).toArray();
        Assertions.assertArrayEquals(new int[]{2,2,2,2},result1);
        Assertions.assertArrayEquals(new int[]{2,3,3},result2);
        Assertions.assertArrayEquals(new int[]{3,5},result3);
    }

    @Test
    void combinationSumTest3() {
        List<List<Integer>> actual = CombinationSumSolution.combinationSum(new int[]{2}, 1);
        Assertions.assertEquals(0,actual.size());
    }
}