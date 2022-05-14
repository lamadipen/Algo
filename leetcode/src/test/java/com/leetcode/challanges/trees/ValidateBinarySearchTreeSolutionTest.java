package com.leetcode.challanges.trees;

import com.leetcode.challanges.stack.ValidParenthesesSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTreeSolutionTest {

    @Test
    void isValidBSTTest1() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1,treeNode3);

        boolean actual = ValidateBinarySearchTreeSolution.isValidBST(treeNode2);
        Assertions.assertTrue(actual);
    }

    @Test
    void isValidBSTTest2() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);

        TreeNode treeNode4 = new TreeNode(4, treeNode3,treeNode6);
        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode5 = new TreeNode(5, treeNode1,treeNode4);

        boolean actual = ValidateBinarySearchTreeSolution.isValidBST(treeNode5);
        Assertions.assertFalse(actual);
    }
}