package com.leetcode.challanges.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleSolutionTest {

    @Test
    void canFinishTest1() {
        boolean actual = CourseScheduleSolution.canFinish(2, new int[][]{{1, 0}});
        Assertions.assertTrue(actual);
    }


    @Test
    void canFinishTest2() {
        boolean actual = CourseScheduleSolution.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        Assertions.assertFalse(actual);
    }

    @Test
    void canFinishTest3() {
        boolean actual = CourseScheduleSolution.canFinish(2, new int[][]{{0, 1}, {1, 3}, {3, 4}, {1, 4}, {0, 2}  });
        Assertions.assertTrue(actual);
    }
}