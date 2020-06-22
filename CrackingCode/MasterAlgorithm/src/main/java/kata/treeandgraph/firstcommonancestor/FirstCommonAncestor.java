package kata.treeandgraph.firstcommonancestor;

import kata.treeandgraph.TreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to
 * find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This
 * is not necessarily a binary search tree
 */
public class FirstCommonAncestor {
    public TreeNode commonAncestorWithLinkToParent(TreeNode node1, TreeNode node2) {
        int delta = getHeight(node1) - getHeight(node2);

        TreeNode first = delta > 0 ? node2 : node1; //shallow (shorter height )
        TreeNode second = delta > 0 ? node1 : node2; //Deeper Node (taller height)

        second = goUpto(second, delta); //bring both shorter and longer  node to same level

        while (first != null && second != null && first != second) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    private TreeNode goUpto(TreeNode node, int delta) {
        while (node != null && delta > 0) {
            delta--;
            node = node.parent;
        }
        return node;
    }

    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.parent;
            height++;
        }
        return height;
    }


    public TreeNode commonAncestorWithoutLinkToParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (!covers(root, node1) || !covers(root, node2)) {
            return null;
        }
        return ancestorHelper(root, node1, node2);
    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root.data == node1.data || root.data == node2.data) {
            return root;
        }
        boolean node1IsOnLeft = covers(root.left, node1);
        boolean node2IsOnLeft = covers(root.left, node2);

        if (node1IsOnLeft != node2IsOnLeft) {
            return root;
        }

        TreeNode newRoot = node1IsOnLeft ? root.left : root.right;
        return ancestorHelper(newRoot, node1, node2);
    }

    private boolean covers(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.data == node.data) {
            return true;
        }
        return covers(root.left, node) || covers(root.right, node);
    }


    /**
     * Third solution optimized without link to parent
     */
    public TreeNode commonAncestorWithoutLinkToParentOptimized(TreeNode root, TreeNode node1, TreeNode node2) {
        Result result = commonAncestorHelperOptimized(root, node1, node2);

        if (result.isAncestor) {
            return result.node;
        }
        return null;
    }

    public Result commonAncestorHelperOptimized(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root.data == node1.data && root.data == node2.data) {
            return new Result(root, true);
        }

        Result left = commonAncestorHelperOptimized(root.left, node1, node2);
        if (left.isAncestor) { //Already found the common ancestor
            return left;
        }

        Result right = commonAncestorHelperOptimized(root.right, node1, node2);
        if (right.isAncestor) {
            return right;
        }

        if (left.node != null && right.node != null) {
            return new Result(root, true);
        } else if (root.data == node1.data || root.data == node2.data) {
            boolean isAncestor = left.node != null || right.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(left.node != null ? left.node : right.node, false);
        }
    }
}

class Result {
    public TreeNode node;
    public boolean isAncestor;

    public Result(TreeNode node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

