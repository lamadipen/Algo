package com.leetcode.challanges.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsSolutionTest {

    @Test
    void numIslandsTest1() {
        char[][] grid= new char[4][5];
        grid[0] = new char[]{'1','1','1','1','0'};
        grid[1] = new char[]{'1','1','0','1','0'};
        grid[2] = new char[]{'1','1','0','0','0'};
        grid[3] = new char[]{'0','0','0','0','0'};

        int actual = NumberOfIslandsSolution.numIslands(grid);

        Assertions.assertEquals(1,actual);
    }

    @Test
    void numIslandsTest2() {
        char[][] grid= new char[4][5];
        grid[0] = new char[]{'1','1','0','0','0'};
        grid[1] = new char[]{'1','1','0','0','0'};
        grid[2] = new char[]{'o','0','1','0','0'};
        grid[3] = new char[]{'0','0','0','1','1'};

        int actual = NumberOfIslandsSolution.numIslands(grid);

        Assertions.assertEquals(3,actual);
    }
}