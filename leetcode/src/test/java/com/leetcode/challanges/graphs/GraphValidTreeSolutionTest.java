package com.leetcode.challanges.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphValidTreeSolutionTest {

    @Test
    void isValidTreeTest1() {
        boolean actual = GraphValidTreeSolution.isValidTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
        Assertions.assertTrue(actual);
    }


    @Test
    void isValidTreeTest2() {
        boolean actual = GraphValidTreeSolution.isValidTree(5, new int[][]{{0, 1}, {0, 2}, {1, 4}});
        Assertions.assertFalse(actual);
    }

    @Test
    void isValidTreeTest3() {
        boolean actual = GraphValidTreeSolution.isValidTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3},{1, 4}, {4,0}});
        Assertions.assertFalse(actual);
    }
}