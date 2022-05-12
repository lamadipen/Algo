package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumDepthofBinaryTreeSolutionTest {

    @Test
    void maxDepthTest1() {
        TreeNode node9 = new TreeNode(9);

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        node20.left = node15;
        node20.right = node7;


        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = node20;

        int actual = MaximumDepthofBinaryTreeSolution.maxDepthDFS(root);
        Assertions.assertEquals(3,actual);

    }
}