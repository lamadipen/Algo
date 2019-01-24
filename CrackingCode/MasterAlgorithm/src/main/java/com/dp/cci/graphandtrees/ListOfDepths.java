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
}
