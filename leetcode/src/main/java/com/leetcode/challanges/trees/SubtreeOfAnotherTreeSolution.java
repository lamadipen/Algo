package com.leetcode.challanges.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * https://www.youtube.com/watch?v=E36O5SWp-LE
 */
public class SubtreeOfAnotherTreeSolution {

    /**
     * Runtime O(r * s) when r is nodes in root and s is nodes in subroot
     * */
    public static boolean isSubtreeSimpleSolution(TreeNode root, TreeNode subRoot) {
        return  isSameTreeValidation(root, subRoot);
    }

    /**
     * Runtime O(r * s) when r is nodes in root and s is nodes in subroot
     * */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode parentSubRoot = null;
        while (!queue.isEmpty()) {
            TreeNode parentNode = queue.poll();
            if (parentNode.val == subRoot.val) {
                parentSubRoot = parentNode;
                break;
            }
            if (parentNode.left != null) {
                queue.add(parentNode.left);
            }
            if (parentNode.right != null) {
                queue.add(parentNode.right);
            }
        }

        if (parentSubRoot == null) {
            return false;
        } else {
            return isSameTreeValidation(parentSubRoot, subRoot);
        }
    }

    public static boolean isSameTreeValidation(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        boolean left = isSameTreeValidation(treeNode1.left, treeNode2.left);
        boolean right = isSameTreeValidation(treeNode1.right, treeNode2.right);

        return left & right;
    }
}
