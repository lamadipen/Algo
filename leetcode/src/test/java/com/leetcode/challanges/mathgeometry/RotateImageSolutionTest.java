package com.leetcode.challanges.mathgeometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageSolutionTest {

    @Test
    void rotateTest1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Source ");
        System.out.println("-------------------");
        Arrays.stream(matrix).forEach(row -> {
            for (int r:row) {
                System.out.print(r +" ");
            }
            System.out.println("");
        });
        System.out.println("-------------------");
        RotateImageSolution.rotate(matrix);

        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assertions.assertArrayEquals(expected,matrix);
    }

    @Test
    void rotateTest2() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Source ");
        System.out.println("-------------------");
        Arrays.stream(matrix).forEach(row -> {
            for (int r:row) {
                System.out.print(r +" ");
            }
            System.out.println("");
        });
        System.out.println("-------------------");
        RotateImageSolution.rotateV2(matrix);

        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assertions.assertArrayEquals(expected,matrix);
    }
}