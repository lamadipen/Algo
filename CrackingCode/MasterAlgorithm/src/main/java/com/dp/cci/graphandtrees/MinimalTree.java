package com.dp.cci.graphandtrees;

/**
 * Created by dipen on 1/21/2019.
 * Minimal Tree
 * Page 242
 * Question 4.2
 * Given : Sorted Array (increasing order )with unique interger element
 * Then : create binary search tree with minimal height
 */
public class MinimalTree {

    public TreeNode createMinimalTree(int[] array) {
        return createMinimalTree(array, 0, array.length - 1);
    }

    public TreeNode createMinimalTree(int[] array, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);

        node.leftNode = createMinimalTree(array, start, mid - 1);
        node.rightNode = createMinimalTree(array, mid + 1, end);

        return node;
    }
}
