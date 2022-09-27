package com.leetcode.challanges.trees;
/**
 * Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * https://www.youtube.com/watch?v=s6ATEkipzow
 * */
public class ValidateBinarySearchTreeSolution {

    /**
     * Runtime O(n)
     * SpaceComplexity O(n)
     * */
    public static  boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if ( (root.left != null &&  root.left.val > root.val) || (root.right != null && root.right.val < root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
