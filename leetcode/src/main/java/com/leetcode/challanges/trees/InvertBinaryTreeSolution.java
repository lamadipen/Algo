package com.leetcode.challanges.trees;
/**
 * Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 *
 * */
public class InvertBinaryTreeSolution {
    /**
     * Used DFS (recursion/ method stack instead of real stack)
     * Runtime O(n)
     *  If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree.
     * */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        right.right = left;

        return root;
    }

    public static TreeNode invertTreeWorkingSolution(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.right = invertTreeWorkingSolution(root.left);
        node.val = root.val;
        node.left = invertTreeWorkingSolution(root.right);
        return node;
    }
}
