package com.leetcode.challanges.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * */
public class BinaryTreeMaximumPathSumSolution {
    public static int maxPathSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxPathSum = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            int pathSum = inOrderTraversal(root);
            maxPathSum = Math.max(pathSum, maxPathSum);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return maxPathSum;
    }

    public static int inOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = inOrderTraversal(root.left);
        int sum = root.val;
        int right = inOrderTraversal(root.right);

        return sum+left + right;
    }


    static int[] result = new int[1];
    /**
     * Runtime O(n)
     * SpaceComplexity O(n)
     * */
    public static int maxPathSumNeetCode(TreeNode root) {
        result[0] = root.val;
        dfs(root);
        return result[0];
    }
    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        result[0] = Math.max(result[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

}
