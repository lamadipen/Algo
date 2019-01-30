package com.dp.cci.graphandtrees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dipen on 1/22/2019.
 * List of Depths
 * Page 243
 * Question 4.3
 * Given : Binary tree
 * Then : create linkedlist of all nodes at each depth
 */
public class ListOfDepths {
    public void createLevelLinkedList_DFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList_DFS(root.leftNode, lists, level + 1);
        createLevelLinkedList_DFS(root.rightNode, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList_BFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                if (parent.leftNode != null) {
                    current.add(parent.leftNode);
                }
                if (parent.rightNode != null) {
                    current.add(parent.rightNode);
                }
            }
        }
        return result;
    }
}
