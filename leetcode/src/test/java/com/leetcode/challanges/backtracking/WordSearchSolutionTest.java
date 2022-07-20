package com.leetcode.challanges.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchSolutionTest {

    @Test
    void existTest1() {
        boolean acutal = WordSearchSolution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED");
        Assertions.assertTrue(acutal);
    }

    @Test
    void existTest2() {
        boolean acutal = WordSearchSolution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}},"SEE");
        Assertions.assertTrue(acutal);
    }

    @Test
    void existTest3() {
        boolean acutal = WordSearchSolution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB");
        Assertions.assertFalse(acutal);
    }
}