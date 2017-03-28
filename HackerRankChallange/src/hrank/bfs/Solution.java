package hrank.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by dipen on 3/15/2017.
 */
public class Solution {

    static void levelOrder(Node root){
        //Write your code here
        if(root != null)
        {
            Queue<Node> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty())
            {
                Node tempRoot = queue.remove();
                System.out.println(tempRoot.data);

                if(tempRoot.left != null)
                {
                    queue.add(tempRoot.left);
                }
                if(tempRoot.right != null)
                {
                    queue.add(tempRoot.right);
                }

            }
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}