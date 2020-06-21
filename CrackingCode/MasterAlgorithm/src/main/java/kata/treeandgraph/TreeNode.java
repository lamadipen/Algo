package kata.treeandgraph;

public class TreeNode<E> {
    public E data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(E data) {
        this.data = data;
    }
}
