package com.leetcode.challanges.mathgeometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixSolutionTest {

    @Test
    void spiralOrderTest1() {
        List<Integer> actual = SpiralMatrixSolution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(9);
        expected.add(8);
        expected.add(7);
        expected.add(4);
        expected.add(5);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void spiralOrderTest2() {
        List<Integer> actual = SpiralMatrixSolution.spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}});
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(8);
        expected.add(12);
        expected.add(11);
        expected.add(10);
        expected.add(9);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        Assertions.assertEquals(expected,actual);
    }
}