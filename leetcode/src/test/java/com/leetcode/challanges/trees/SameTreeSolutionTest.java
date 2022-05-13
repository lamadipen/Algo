package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameTreeSolutionTest {

    @Test
    void isSameTreeTest1() {
        TreeNode tree1Node3 = new TreeNode(3);
        TreeNode tree1Node2 = new TreeNode(2);
        TreeNode tree1Node1 = new TreeNode(1);
        tree1Node1.left =tree1Node2;
        tree1Node1.right=tree1Node3;

        TreeNode tree2Node3 = new TreeNode(3);
        TreeNode tree2Node2 = new TreeNode(2);
        TreeNode tree2Node1 = new TreeNode(1);
        tree2Node1.left =tree2Node2;
        tree2Node1.right=tree2Node3;


        boolean actual = SameTreeSolution.isSameTree(tree1Node1, tree2Node1);
        Assertions.assertTrue(actual);
    }


    @Test
    void isSameTreeTest2() {
        TreeNode tree1Node2 = new TreeNode(2);
        TreeNode tree1Node1 = new TreeNode(1);
        tree1Node1.left =tree1Node2;

        TreeNode tree2Node2 = new TreeNode(2);
        TreeNode tree2Node1 = new TreeNode(1);
        tree2Node1.right=tree2Node2;


        boolean actual = SameTreeSolution.isSameTree(tree1Node1, tree2Node1);
        Assertions.assertFalse(actual);
    }
}