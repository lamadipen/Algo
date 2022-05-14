package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementInBSTSolutionTest {

    @Test
    void kthSmallestTest1() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1,null,treeNode2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode1,treeNode4);

        int actual = KthSmallestElementInBSTSolution.kthSmallest(treeNode3,1);
        Assertions.assertEquals(1,actual);
    }


    @Test
    void kthSmallestTest2() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2,treeNode1,null);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode2, treeNode4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5,treeNode3,treeNode6);

        int actual = KthSmallestElementInBSTSolution.kthSmallest(treeNode5, 3);
        Assertions.assertEquals(3,actual);
    }
}