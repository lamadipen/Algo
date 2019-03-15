package com.dp.cci.graphandtrees;

import java.util.Scanner;

public class HeightOfBinaryTree {
    //solution
    public static int height(NodeHrank root) {

        if(root == null){
            return -1;
        }
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    public static NodeHrank insert(NodeHrank root, int data) {
        if(root == null) {
            return new NodeHrank(data);
        } else {
            NodeHrank cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    /**
     * Input
     *7
     * 3 5 2 1 4 6 7
     *
     * **/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        NodeHrank root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }


}

class NodeHrank{

    public NodeHrank(int data) {
        this.data = data;
    }

    int data;
    NodeHrank left;
    NodeHrank right;
}
