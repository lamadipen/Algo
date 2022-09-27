package com.leetcode.challanges.trees;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 *  https://www.youtube.com/watch?v=ihj4IQGZ2zc
 * */
public class ConstructBinaryTreefromPreorderAndInorderTraversalSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = IntStream
                .range(0,inorder.length)
                .filter(i -> inorder[i] == root.val)
                .findFirst()
                .orElse(-1);

        root.left = buildTree(copyOfRange(preorder,1,mid+1),copyOfRange(inorder,0,mid));
        root.right = buildTree(copyOfRange(preorder,mid+1,preorder.length),copyOfRange(inorder,mid+1,inorder.length));

        return root;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength <= 0)
            return null;
        int[] copy = new int[newLength];
        System.arraycopy(original, from, copy, 0,
                Math.min(original.length - from, newLength));
        return copy;
    }
}
