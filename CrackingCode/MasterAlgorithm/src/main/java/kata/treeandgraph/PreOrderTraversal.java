package kata.treeandgraph;

public class PreOrderTraversal {
    public void traverse(TreeNode<Integer> root) {
        if (root != null) {
            visited(root);
            traverse(root.left);
            traverse(root.right);
        }
    }

    private void visited(TreeNode node) {
        //add to some datastrucure
        System.out.print(node.data + " -> ");
    }
}
