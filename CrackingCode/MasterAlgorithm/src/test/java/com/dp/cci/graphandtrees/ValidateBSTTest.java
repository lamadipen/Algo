package com.dp.cci.graphandtrees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateBSTTest {
    private ValidateBST validateBST;
    private TreeNode start, end, node1, node2, node3, node4, node5;

    @Before
    public void setUp() {
        validateBST = new ValidateBST();
        start = new TreeNode(10);
        node1 = new TreeNode(5);
        node2 = new TreeNode(15);
        node3 = new TreeNode(2);
        node4 = new TreeNode(7);
        node5 = new TreeNode(12);
        end = new TreeNode(18);
        start.leftNode = node1;
        start.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        node2.leftNode = node5;

    }

    @Test
    public void isValidBST_successful() {
        assertTrue(validateBST.isValidBSTInorderTracersal(start));
    }

    @Test
    public void isValidBST_unsuccessful() {
        node3.rightNode = end;
        assertFalse(validateBST.isValidBSTInorderTracersal(start));
    }
}
