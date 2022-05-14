package com.leetcode.challanges.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversalSolution {

    /**
     * Runtime O()
     * Space Complexity O(n)
     * */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> visited = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode tn = queue.poll();
                list.add(tn.val);
                visited.add(tn);
            }
            int size = visited.size();

            while (size > 0){
                TreeNode treeNode = visited.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);

                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                size--;
            }

            result.add(list);

        }

        return result;
    }
}
