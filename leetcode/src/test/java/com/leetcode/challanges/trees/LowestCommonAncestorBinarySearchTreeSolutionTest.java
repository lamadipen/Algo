package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorBinarySearchTreeSolutionTest {

    @Test
    void lowestCommonAncestorTest1() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4,treeNode3,treeNode5);

        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(4,treeNode0,treeNode4);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8,treeNode7,treeNode9);

        TreeNode treeNode6 = new TreeNode(6,treeNode2,treeNode8);

        TreeNode actual = LowestCommonAncestorBinarySearchTreeSolution.lowestCommonAncestor(treeNode6,treeNode2,treeNode8);
        Assertions.assertEquals(6,actual.val);
    }

    @Test
    void lowestCommonAncestorTest2() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4,treeNode3,treeNode5);

        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(4,treeNode0,treeNode4);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8,treeNode7,treeNode9);

        TreeNode treeNode6 = new TreeNode(6,treeNode2,treeNode8);

        TreeNode actual = LowestCommonAncestorBinarySearchTreeSolution.lowestCommonAncestor(treeNode6,treeNode2,treeNode4);
        Assertions.assertEquals(4,actual.val);
    }

    @Test
    void lowestCommonAncestorTest3() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4,treeNode3,treeNode5);

        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(4,treeNode0,treeNode4);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8,treeNode7,treeNode9);

        TreeNode treeNode6 = new TreeNode(6,treeNode2,treeNode8);

        TreeNode actual = LowestCommonAncestorBinarySearchTreeSolution.lowestCommonAncestor(treeNode6, treeNode3, treeNode5);
        Assertions.assertEquals(4,actual.val);
    }


}