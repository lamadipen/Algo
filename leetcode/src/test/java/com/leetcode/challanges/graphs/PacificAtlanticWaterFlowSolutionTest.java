package com.leetcode.challanges.graphs;

import com.leetcode.challanges.oneDDynamicProgramming.PalindromicSubstringsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacificAtlanticWaterFlowSolutionTest {

    @Test
    void pacificAtlanticTest() {
        List<List<Integer>> actual = PacificAtlanticWaterFlowSolution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        Assertions.assertTrue(actual.size() >0);
    }
}