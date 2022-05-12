package com.leetcode.challanges.trees;
/**
 * Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 * */
public class InvertBinaryTreeSolution {
    /**
     * Used DFS (recursion/ method stack instead of real stack)
     * Runtime O(n)
     *  If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree.
     * */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)return null;

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
