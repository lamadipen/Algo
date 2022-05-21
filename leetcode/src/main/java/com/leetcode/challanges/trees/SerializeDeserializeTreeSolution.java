package com.leetcode.challanges.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * */
public class SerializeDeserializeTreeSolution {
    /**
     * Encodes a tree to a single string.
     * Runtime O(n)
     * SpaceComplexity O(n)
     * Preorder Traversal
     */
    public static String serialize(TreeNode root) {
        if(root == null)return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> nodeLeft = new LinkedList<>();
        nodeLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodeLeft);
    }

    private static TreeNode deserializeHelper(Queue<String> nodesRemaining) {
        String current = nodesRemaining.poll();
        if(current.equals("X")) return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(current));
        newNode.left = deserializeHelper(nodesRemaining);
        newNode.right = deserializeHelper(nodesRemaining);

        return newNode;
    }


}
