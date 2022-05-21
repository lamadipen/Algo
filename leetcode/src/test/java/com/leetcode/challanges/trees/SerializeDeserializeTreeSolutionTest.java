package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeDeserializeTreeSolutionTest {

    @Test
    void serializeTest1() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3,treeNode4,treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2,treeNode3);

        String actual = SerializeDeserializeTreeSolution.serialize(treeNode1);

        Assertions.assertEquals("1,2,X,X,3,4,X,X,5,X,X,", actual);
    }

    @Test
    void deserializeTest1() {
        TreeNode actual = SerializeDeserializeTreeSolution.deserialize("1,2,X,X,3,4,X,X,5,X,X,");

        Assertions.assertEquals(actual.val,1);
        Assertions.assertEquals(actual.left.val,2);
        Assertions.assertEquals(actual.right.val,3);
        Assertions.assertEquals(actual.right.left.val,4);
        Assertions.assertEquals(actual.right.right.val,5);
    }
}