package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeMaximumPathSumSolutionTest {

    @Test
    void maxPathSumTest1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1,node2,node3);

        int actual = BinaryTreeMaximumPathSumSolution.maxPathSum(node1);
        Assertions.assertEquals(6,actual);
    }

    @Test
    void maxPathSumTest2() {
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode nodeMinus10 = new TreeNode(-10,node9,node20);

        int actual = BinaryTreeMaximumPathSumSolution.maxPathSum(nodeMinus10);
        Assertions.assertEquals(42,actual);
    }


    @Test
    void maxPathSumTest3() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1,node2,node3);

        int actual = BinaryTreeMaximumPathSumSolution.maxPathSumNeetCode(node1);
        Assertions.assertEquals(6,actual);
    }

    @Test
    void maxPathSumTest4() {
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode nodeMinus10 = new TreeNode(-10,node9,node20);

        int actual = BinaryTreeMaximumPathSumSolution.maxPathSumNeetCode(nodeMinus10);
        Assertions.assertEquals(42,actual);
    }
}