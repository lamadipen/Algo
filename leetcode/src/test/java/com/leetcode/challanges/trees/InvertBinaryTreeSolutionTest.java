package com.leetcode.challanges.trees;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeSolutionTest {

    @Test
    void invertTreeTest1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.left = node1;
        node2.right = node3;

        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7);
        node7.left = node6;
        node7.right = node9;


        TreeNode root = new TreeNode(4);
        root.left = node2;
        root.right = node7;

        TreeNode treeNode = InvertBinaryTreeSolution.invertTree(root);
        printTree(treeNode);
        System.out.println("_________Inorder traversal_______");
        inorderTraversal(treeNode);

        System.out.println("_________Preorder traversal_______");
        preorderTraversal(treeNode);

        System.out.println("_________Postorder traversal_______");
        postorderTraversal(treeNode);
    }

    /**
     * BFS using queue to traverse the BinaryTree
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public void printTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode visitedNode = queue.poll();
            System.out.println("visitedNode = " + visitedNode.val);

            if (visitedNode.left != null) {
                queue.add(visitedNode.left);
            }

            if (visitedNode.right != null) {
                queue.add(visitedNode.right);
            }
        }
    }

    /**
     *    Inorder Traversal
     *
     *    Inorder (Left, Root, Right)
     *
     *    1. Traverse the left subtree, i.e., call Inorder(left-subtree)
     *    2. Visit the root.
     *    3. Traverse the right subtree, i.e., call Inorder(right-subtree)
     *
     *    Runtime O(n)
     *     *  If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree.
     *
     *
     * */
    public void inorderTraversal(TreeNode node) {
        if(node == null)return;
        inorderTraversal(node.left);
        System.out.println("node.val = " + node.val);
        inorderTraversal(node.right);
    }

    /**
     *    Preorder Traversal
     *
     *    Preorder (Root, Left, Right)
     *
     *    1. Visit the root.
     *    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
     *    3. Traverse the right subtree, i.e., call Preorder(right-subtree)
     *    Runtime O(n)
     *     *  If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree.
     * */
    public void preorderTraversal(TreeNode node) {
        if(node == null)return;
        System.out.println("node.val = " + node.val);
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    /**
     *    Postorder Traversal
     *     Postorder (Left, Right, Root)
     *
     *    1. Traverse the left subtree, i.e., call Postorder(left-subtree)
     *    2. Traverse the right subtree, i.e., call Postorder(right-subtree)
     *    3. Visit the root.
     *    Runtime O(n)
     *     *  If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree.
     * */
    public void postorderTraversal(TreeNode node) {
        if(node == null)return;
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.println("node.val = " + node.val);
    }
}