package com.dp.cci.graphandtrees;

import lombok.Getter;

/**
 * Created by dipen on 1/21/2019.
 */
@Getter
public class TreeNode {

    public TreeNode leftNode;
    public TreeNode rightNode;
    private int data;

    public TreeNode(int data) {
        this.data = data;
    }
}
