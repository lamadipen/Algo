package com.dp.cci.graphandtrees;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

;


/**
 * Created by dipen on 1/21/2019.
 */
class MinimalTreeTest {

    private MinimalTree minimalTree;
    private int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    ;

    @BeforeEach
    public void setUp() {
        minimalTree = new MinimalTree();
    }

    @Test
    void createMinimalTreeTest() {
        TreeNode node = minimalTree.createMinimalTree(data);
        Assertions.assertNotNull(node);
    }

}