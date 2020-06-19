package kata.treeandgraph;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purpose of this question, a balanced tree is defined
 * to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
public class CheckBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);

        if (heightDiff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) return -1;
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }
}
