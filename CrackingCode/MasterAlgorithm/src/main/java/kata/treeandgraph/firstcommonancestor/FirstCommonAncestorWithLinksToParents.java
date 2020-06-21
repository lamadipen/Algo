package kata.treeandgraph.firstcommonancestor;

import kata.treeandgraph.TreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to
 * find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This
 * is not necessarily a binary search tree
 */
public class FirstCommonAncestorWithLinksToParents {
    public TreeNode commonAncestor(TreeNode node1, TreeNode node2) {
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
}
