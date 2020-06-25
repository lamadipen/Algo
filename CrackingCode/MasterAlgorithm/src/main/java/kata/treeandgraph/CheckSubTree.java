package kata.treeandgraph;

/**
 * Check subtree:
 * CC: pg 111 Q: 4.10
 */
public class CheckSubTree {

    /**
     * @param node1 Main tree
     * @param node2 sub tree that needs to searched in main tree
     * @return boolean
     */
    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        preOrderTraversal(node1, sb1);
        preOrderTraversal(node2, sb2);
        return sb1.indexOf(sb2.toString()) != -1;
    }

    private void preOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.data + "");
        preOrderTraversal(node.left, sb);
        preOrderTraversal(node.right, sb);
    }

    public boolean isSubTreeAlternative(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        return subTree(node1, node2);
    }

    private boolean subTree(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return false;
        } else if (node1.data == node2.data && matchTree(node1, node2)) {
            return true;
        }
        return subTree(node1.left, node2) || subTree(node1.right, node2);
    }

    private boolean matchTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true; //nothing left to compare in sub tee
        } else if (node1 == null || node2 == null) {
            return false; //one of the tree is empty
        } else if (node1.data != node2.data) {
            return false; //data in same level doesn't match
        } else {
            return matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
        }

    }
}
