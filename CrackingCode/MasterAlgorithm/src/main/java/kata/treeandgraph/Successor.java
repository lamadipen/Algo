package kata.treeandgraph;

public class Successor {

    public TreeNode getSuccessor(TreeNode root) {
        if (null == root) {
            return null;
        }

        /** If root has right subtree get the left most node
         *  else
         *
         *  See the inorder traversal and successor is node that will
         *  appear after a given node.
         *
         *  [1 2 3 4 7 8 9]
         *
         *  2 is succesor of 1
         *  8 is successor of 7
         *  9 is successor of 8
         *  null is successor of 9
         * */
        if (null != root.right) {
            return getLeftMostChild(root.right);
        } else {
            TreeNode current = root;
            TreeNode parent = current.parent;

            while (null != parent && parent.left != current) {
                current = parent;
                parent = current.parent;
            }
            return parent;
        }
    }

    private TreeNode getLeftMostChild(TreeNode node) {
        if (null == node) {
            return null;
        }
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

}
