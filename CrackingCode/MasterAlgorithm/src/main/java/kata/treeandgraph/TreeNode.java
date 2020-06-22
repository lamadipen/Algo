package kata.treeandgraph;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return data.equals(treeNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
