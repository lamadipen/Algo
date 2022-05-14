package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtreeOfAnotherTreeSolutionTest {

    @Test
    void isSubtreeTest1() {

        TreeNode tree1Node1 = new TreeNode(1);
        TreeNode tree1Node2 = new TreeNode(2);
        TreeNode tree1Node4 = new TreeNode(4);
        tree1Node4.left =tree1Node1;
        tree1Node4.right = tree1Node2;

        TreeNode tree1Node5 = new TreeNode(5);
        TreeNode tree1Node3 = new TreeNode(3);
        tree1Node3.left =tree1Node4;
        tree1Node3.right =tree1Node5;

        TreeNode tree2Node1 = new TreeNode(1);
        TreeNode tree2Node2 = new TreeNode(2);
        TreeNode tree2Node4 = new TreeNode(4);
        tree2Node4.left=tree2Node1;
        tree2Node4.right=tree2Node2;

        boolean actual = SubtreeOfAnotherTreeSolution.isSubtree(tree1Node3, tree2Node4);
        Assertions.assertTrue(actual);
    }
}