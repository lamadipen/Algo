package com.leetcode.challanges.trees;

import java.util.*;

/**
 * Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 *
 */
public class MaximumDepthofBinaryTreeSolution {

    public static int maxDepthDFS(TreeNode root) {
        return maxDepthDFS(root, 0);
    }

    /**
     * DFS Solution
     * Runtime O(n)
     * Space Complexity O(h) where h is height of the tree.
     *
     * */
    public static int maxDepthDFS(TreeNode root, int counter) {
        if (root == null) return 0;
        int leftLength = maxDepthDFS(root.left) + 1;
        int rightLength = maxDepthDFS(root.right) + 1;
        return Math.max(leftLength, rightLength);
    }

    /**
     * Iterative DFS Solution
     * Runtime O(n)
     * Space Complexity O(n)
     *
     * */
    public static int maxDepthIterativeDFS(TreeNode root, int counter) {
        if (root == null) return 0;
        Stack<NodePair> stack = new Stack<>();

        stack.add(new NodePair(root, 1));
        int result = 0;

        while (!stack.isEmpty()) {
            NodePair nodePair = stack.pop();
            TreeNode treeNode = nodePair.treeNode;
            if (treeNode != null) {
                result = Math.max(result, nodePair.depth);
                stack.add(new NodePair(treeNode.left, nodePair.depth));
                stack.add(new NodePair(treeNode.right, nodePair.depth));
            }
        }
        return result;
    }

    static class NodePair{
        TreeNode treeNode;
        int depth;

        public NodePair(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.depth = sum;
        }
    }

    /**
     * BFS Solution
     * Runtime O(n)
     * Space Complexity O(n)
     *
     * */
    public static int maxDepthBFS(TreeNode root, int counter) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level =0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            level++;
        }
        return level;
    }


    public int maxDepthNeetcode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 1;
        }
        else {
            return 1 + Math.max(maxDepthNeetcode(root.left),maxDepthNeetcode(root.right));
        }
    }


}
