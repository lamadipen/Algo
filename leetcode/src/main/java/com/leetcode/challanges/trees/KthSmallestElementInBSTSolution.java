package com.leetcode.challanges.trees;

import java.util.*;

/**
 * Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * https://www.youtube.com/watch?v=5LUXSvjmGCw
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

    public int kthSmallestCorrectOne(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.isEmpty()? 0:list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
