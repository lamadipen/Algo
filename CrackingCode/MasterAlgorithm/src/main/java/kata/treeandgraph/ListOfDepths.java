package kata.treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/** List of Depths CC pg 109 Question 4.3
 * Given a binary tree design an algorithm which creates a linked list of
 * all the nodes at each depth (e.g if you have a tree with depth D, you
 * will have D linkedList
 * */
public class ListOfDepths {
    public List<LinkedList<TreeNode>> createLevelDFS(TreeNode root) {
        List<LinkedList<TreeNode>> list = new ArrayList<>();
        createLevelDFS(root, list, 0);
        return list;
    }

    private void createLevelDFS(TreeNode root, List<LinkedList<TreeNode>> list, int level) {
        if (root == null) return;

        LinkedList<TreeNode> currentLevel = null;

        if (list.size() == level) {
            currentLevel = new LinkedList<>();
            list.add(currentLevel);
        } else {
            currentLevel = list.get(level);
        }
        currentLevel.addLast(root);

        createLevelDFS(root.left, list, level + 1);
        createLevelDFS(root.right, list, level + 1);
    }


    public List<LinkedList<TreeNode>> createLevelBFS(TreeNode root) {
        List<LinkedList<TreeNode>> list = new ArrayList<>();
        LinkedList<TreeNode> currentLevel = new LinkedList<>();

        if (root != null) {
            currentLevel.add(root);
        }

        while (!currentLevel.isEmpty()) {
            list.add(currentLevel); //add previous level
            List<TreeNode> parent = currentLevel;  //Go to next level
            currentLevel = new LinkedList<>();
            for (TreeNode node : parent) {
                if (node.left != null) {
                    currentLevel.add(node.left);
                }
                if(node.right != null){
                    currentLevel.add(node.right);
                }
            }
        }
        return list;
    }
}
