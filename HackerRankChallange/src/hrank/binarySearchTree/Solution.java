package hrank.binarySearchTree;

/**
 * Created by dipen on 3/7/2017.
 */
import java.util.*;
import java.io.*;

class Solution{
    public static int getHeight(Node root){
        //Write your code here
        Node leftRoot = root;
        Node leftRRoot = root;
        Node rightRoot =root;
        Node rightLRoot =root;
        int leftRHeight = 0;
        int leftHeight  = 0;
        int rightHeight = 0;
        int rightLHeight =0 ;

        while(leftRoot.left != null)
        {
            leftHeight++;
            //System.out.println(leftHeight);
            leftRoot = leftRoot.left;
        }
        while(leftRRoot.left.right != null)
        {
            leftRHeight++;
            //System.out.println(leftHeight);
            leftRRoot = leftRRoot.left.right;
        }

        while(rightRoot.right != null)
        {
            rightHeight++;
            //System.out.println(leftHeight);
            rightRoot = rightRoot.right;
        }

        while(rightLRoot.right.left != null)
        {
            rightLHeight++;
            //System.out.println(leftHeight);
            rightLRoot = rightLRoot.right;
        }
        int leftMaxH =0;
        int rightMaxH =0;
        if(leftHeight > leftRHeight)
        {
            leftMaxH = leftHeight;
        }
        else {
            leftMaxH = leftRHeight;
        }
        if(rightHeight > rightLHeight)
        {
            rightMaxH = rightHeight;
        }
        else
        {
            rightMaxH = rightLHeight;
        }

        if(leftMaxH > rightMaxH)
        {
            return leftMaxH;
        }
        else {
            return rightMaxH;
        }
        /**
        if(rightHeight > leftHeight)
        {
            return rightHeight;
        }
        else if(rightHeight < leftHeight){
            return leftHeight;
        }
        else if(rightLHeight > leftRHeight)
        {
            return rightLHeight;
        }else
        {
            return leftRHeight;
        }
         **/

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
        int height=getHeight(root);
        System.out.println(height);
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

/** sample input
 7
 3
 5
 2
 1
 4
 6
 7
 **/