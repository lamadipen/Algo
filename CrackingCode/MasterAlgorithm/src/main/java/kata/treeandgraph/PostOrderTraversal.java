package kata.treeandgraph;

/**
 * postorder traversal visit left -> right -> current
 * */
public class PostOrderTraversal {

    public void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            traverse(root.right);
            visited(root);
        }
    }

    private void visited(TreeNode node) {
        //add to some datastrucure
        System.out.print(node.data + " -> ");
    }
}
