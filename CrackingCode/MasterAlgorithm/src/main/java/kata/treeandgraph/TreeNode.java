package kata.treeandgraph;

public class TreeNode<E> {
    E data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(E data) {
        this.data = data;
    }
}
