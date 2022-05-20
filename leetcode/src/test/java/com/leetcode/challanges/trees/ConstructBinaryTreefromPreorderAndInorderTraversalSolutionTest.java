package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreefromPreorderAndInorderTraversalSolutionTest {

    @Test
    void buildTreeTest1() {
        TreeNode treeNode = ConstructBinaryTreefromPreorderAndInorderTraversalSolution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        Assertions.assertEquals(treeNode.val, 3);
        Assertions.assertEquals(treeNode.left.val, 9);
        Assertions.assertEquals(treeNode.right.val, 20);
        Assertions.assertEquals(treeNode.right.left.val, 15);
        Assertions.assertEquals(treeNode.right.right.val, 7);
    }
}