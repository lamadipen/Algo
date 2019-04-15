package com.dp.hrank;

import com.dp.cci.graphandtrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * You are given a pointer to the root of a binary tree.
 * You need to print the level order traversal of this tree.
 * In level order traversal, we visit the nodes level by level from left to right.
 * You only have to complete the function
 *
 * @Input
 * 6
 * 1 2 5 3 6 4
 *
 * @Output
 * 1 2 5 3 6 4
 *
 * */
public class LevelOrderTraversal {

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.getData() + " ");

            if(temp.leftNode != null){
                queue.add(temp.leftNode);
            }
            if (temp.rightNode != null) {
                queue.add(temp.rightNode);
            }
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.getData()) {
                cur = insert(root.leftNode, data);
                root.leftNode = cur;
            } else {
                cur = insert(root.rightNode, data);
                root.rightNode = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
