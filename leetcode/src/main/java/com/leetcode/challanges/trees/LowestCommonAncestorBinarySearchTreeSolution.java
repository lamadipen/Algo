package com.leetcode.challanges.trees;
/**
 * Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * https://www.youtube.com/watch?v=gs2LMfuOR9k
 * */
public class LowestCommonAncestorBinarySearchTreeSolution {
    /***
     * Runtime O(logn) where n is number of nodes
     * SpaceComplexity O(1);
     * */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }   else {
                return current;
            }
        }
        return current;
    }
}
