package com.dp.cci.graphandtrees;

/**
 * Created by dipen on 1/30/2019.
 * Validate BST
 * Page 245
 * Question 4.5
 * Given : Binary tree
 * Then : check if it is a binary search tree
 */
public class ValidateBST {
    private int index = 0;

    public boolean isValidBSTInorderTracersal(TreeNode root) {
        int[] array = new int[7];
        inorderTraversal(root, array);
        for (int i = 1; i < array.length - 1; i++) {
            System.out.println(array[i]);
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //this solution cannot handle duplicate values
    public void inorderTraversal(TreeNode root, int[] arr) {
        if (root == null) return;
        inorderTraversal(root.leftNode, arr);
        arr[index] = root.getData();
        index++;
        inorderTraversal(root.rightNode, arr);
    }

    public boolean checkBST(TreeNode treeNode) {
        return checkBST(treeNode, null, null);
    }

    //optimized solution
    //leverage the definition of left.data <= current.data < right.data
    public boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max)) {
            return false;
        }
        if (!checkBST(root.leftNode, min, root.getData()) || !checkBST(root.rightNode, root.getData(), max)) {
            return false;
        }
        return true;
    }
}
