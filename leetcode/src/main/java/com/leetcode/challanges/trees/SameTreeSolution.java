package com.leetcode.challanges.trees;
/**
 * Same Tree
 * https://leetcode.com/problems/same-tree/
 * */
public class SameTreeSolution {
    /**
     * Runtime O(p + q) where p and q are the length of the tree
     * Space Complexity If we don’t consider the size of the stack for function calls then O(1) otherwise O(p + q) where h is the height of the tree.
     *
     * */
    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return  false;
        if(root1.val != root2. val) return false;

        boolean leftResult= isSameTree(root1.left, root2.left);
        boolean rightResult= isSameTree(root1.right, root2.right);

        return leftResult && rightResult;
    }
}
