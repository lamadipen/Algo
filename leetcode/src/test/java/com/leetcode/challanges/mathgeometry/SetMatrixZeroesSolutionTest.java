package com.leetcode.challanges.mathgeometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetMatrixZeroesSolutionTest {

    @Test
    void setZeroesTest1() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SetMatrixZeroesSolution.setZeroes(matrix);
        int[][] expected = {{1,0,1}, {0, 0, 0}, {1, 0, 1}};
        Assertions.assertArrayEquals(expected,matrix);
    }


    @Test
    void setZeroesTest2() {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        SetMatrixZeroesSolution.setZeroes(matrix);
        int[][] expected = {{0,0,0,0}, {0,4,5,0}, {0,3,1,0}};
        Assertions.assertArrayEquals(expected,matrix);
    }
}