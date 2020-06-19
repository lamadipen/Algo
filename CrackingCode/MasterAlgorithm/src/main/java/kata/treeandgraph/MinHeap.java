package kata.treeandgraph;

/**
 * Min Heap is a complete binary tree where all levels are
 * filled other than the rightest most part of the last level.
 */
public class MinHeap {
    TreeNode<Integer> root;

    public void insertElement(int data) {
        if (root == null) {
            root = new TreeNode(data);
        }
        TreeNode newNode = new TreeNode(data);
        if (root.left == null) {
            root.left = newNode;
        } else {
            root.right = newNode;
        }
    }

    public int peekMinElement() {
        if (root == null) {
            throw new RuntimeException("No Min Element Available");
        }
        return root.data;
    }

    public void removeMinElement() {

    }
}
