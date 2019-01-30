package com.dp.cci.graphandtrees;

public class CheckBalanced {
    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.leftNode), getHeight(root.rightNode)) + 1;
    }

    public boolean isbalanced(TreeNode start) {
        //base case
        if (start == null) {
            return true;
        }

        int heightDiff = getHeight(start.leftNode) - getHeight(start.rightNode);

        if (Math.abs(heightDiff) > 1) {
            return false;
        } else { // recurse
            return isbalanced(start.leftNode) && isbalanced(start.rightNode);
        }
    }


    public int isBalancedOptimized(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = isBalancedOptimized(root.leftNode);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = isBalancedOptimized(root.rightNode);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight);
        }
    }
}
