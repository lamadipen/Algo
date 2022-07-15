package com.leetcode.challanges.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfConnectedComponentsInGraphSolutionTest {

    @Test
    void numOfConnectedComponentTest1() {
        int actual = NumberOfConnectedComponentsInGraphSolution.numOfConnectedComponent(5,new int[][]{{0,1}, {1,2}, {3,4}});
        Assertions.assertEquals(2,actual);
    }


    @Test
    void numOfConnectedComponentTest2() {
        int actual = NumberOfConnectedComponentsInGraphSolution.numOfConnectedComponent(4,new int[][]{{0,1}, {1,2}, {2,3}});
        Assertions.assertEquals(1,actual);
    }

    @Test
    void numOfConnectedComponentTest3() {
        int actual = NumberOfConnectedComponentsInGraphSolution.unionFindSolution(5,new int[][]{{0,1}, {1,2}, {3,4}});
        Assertions.assertEquals(2,actual);
    }
}