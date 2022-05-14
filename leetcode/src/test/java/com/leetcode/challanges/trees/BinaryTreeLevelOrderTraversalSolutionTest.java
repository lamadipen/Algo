package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTraversalSolutionTest {

    @Test
    void levelOrderTest1() {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20, treeNode15,treeNode7);
        TreeNode treeNode3 = new TreeNode(3, treeNode9,treeNode20);

        List<List<Integer>> actual = BinaryTreeLevelOrderTraversalSolution.levelOrder(treeNode3);


        Assertions.assertEquals(3,actual.size());
        Assertions.assertEquals(3,actual.get(0).get(0));
        Assertions.assertEquals(9,actual.get(1).get(0));
        Assertions.assertEquals(20,actual.get(1).get(1));
        Assertions.assertEquals(15,actual.get(2).get(0));
        Assertions.assertEquals(7,actual.get(2).get(1));

    }


    @Test
    void levelOrderTest2() {
        TreeNode treeNode1 = new TreeNode(1);
        List<List<Integer>> actual = BinaryTreeLevelOrderTraversalSolution.levelOrder(treeNode1);

        Assertions.assertEquals(1,actual.size());
        Assertions.assertEquals(1,actual.get(0).get(0));
    }
}