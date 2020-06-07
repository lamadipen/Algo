package kata.treeandgraph;
/** Valid BST Pg 110 Question 4.5
 * Implement a function to check if a binary Tree is a binary Search Tree
 *
 * left <= root < right
 * */
public class ValidBST {

    public boolean isValidBST(TreeNode<Integer> root) {
        if(root == null) return true;
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode<Integer> root, Integer min, Integer max) {
        if(root == null) return true;
        /** left should be always less that max value
         *  right should be always greater than min value
         * */
        if ((max != null && root.data > max) || (min != null && root.data <= min)) {
            return false;
        }

        if (!isValidBST(root.left, min, root.data ) || !isValidBST(root.right, root.data, max)) {
            return false;
        }
        return true;
    }
}
