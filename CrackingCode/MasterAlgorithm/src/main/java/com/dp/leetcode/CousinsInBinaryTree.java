package com.dp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInBinaryTree {
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);

        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);

        }
    }



}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 **/
