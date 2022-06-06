package com.leetcode.challanges.intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalSolutionTest {

    @Test
    public void insertTest1() {
        int[][] insert = InsertIntervalSolution.insert(new int[][]{new int[]{1,3},new int[]{6,9} }, new int[]{2,5});
        Arrays.stream(insert).forEach(interval -> System.out.println("Arrays.toString(interval) = " + Arrays.toString(interval)));
    }


    @Test
    public void insertTest2() {
        int[][] insert = InsertIntervalSolution.insert(new int[][]{new int[]{1,2},new int[]{3,5} }, new int[]{6,7});
        Arrays.stream(insert).forEach(interval -> System.out.println("Arrays.toString(interval) = " + Arrays.toString(interval)));
    }
}