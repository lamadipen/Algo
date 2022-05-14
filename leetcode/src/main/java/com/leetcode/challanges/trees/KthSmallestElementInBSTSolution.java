package com.leetcode.challanges.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * */
public class KthSmallestElementInBSTSolution {
    /**
     * Runtime O(n)
     * SpaceComplexity O(n)
     * */
    public static int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.val == k) {
                return treeNode.val;
            }
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return 0;
    }
}
