package kata.treeandgraph.randomNode;

import java.util.Random;

/**
 * Random Node
 * CC: pg 111 Q: 4.11
 */
public class TreeOptimized {
    TreeNode root = null;

    public void insertInOrder(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.addNodeInorder(data);
        }
    }

    public TreeNode findRandomNode() {
        if (root == null) return null;
        Random random = new Random();
        int index = random.nextInt(root.size);
        return root.findByIndex(index);
    }
}
