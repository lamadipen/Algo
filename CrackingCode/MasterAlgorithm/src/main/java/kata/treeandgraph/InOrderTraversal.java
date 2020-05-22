package kata.treeandgraph;
/**
 * inorder traversal visit left -> current -> right
 * */
public class InOrderTraversal {
    public void traverse(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        System.out.print(root.data + " -> ");
        traverse(root.right);
    }
}
