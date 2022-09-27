package com.leetcode.challanges.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * https://www.youtube.com/watch?v=6ZnyEApgFYg
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

    public List<List<Integer>> levelOrderOptimized(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
