package com.dp.cci.graphandtrees;


import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckBalancedTest {
    private CheckBalanced checkBalanced;
    private TreeNode start, end, node1, node2, node3, node4, node5;

    @Before
    public void setUp() throws Exception {
        checkBalanced = new CheckBalanced();
        start = new TreeNode(10);
        node1 = new TreeNode(5);
        node2 = new TreeNode(15);
        node3 = new TreeNode(2);
        node4 = new TreeNode(7);
        node5 = new TreeNode(12);
        end = new TreeNode(2);
        start.leftNode = node1;
        start.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        node2.leftNode = node5;
    }

    @Test
    public void getHeightTest_success() {
        int height = checkBalanced.getHeight(start);
        System.out.printf("Height of the tree : " + height);
    }

    @Test
    public void getHeightTest_withNoHeight() {
        node5.leftNode = end;
        assertNotEquals(-1, checkBalanced.getHeight(start));
        assertEquals(-1, checkBalanced.getHeight(null));
    }

    @Test
    public void checkBalancedTree_test() {
        assertTrue(checkBalanced.isbalanced(start));
    }


}
