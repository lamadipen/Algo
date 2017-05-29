package hrank.IsThisaBinarySearchTree;

import hrank.IsThisaBinarySearchTree.BSTExample.Node;

import java.util.ArrayList;

/**
 * Created by dipen on 5/28/2017.
 */
public class Solution {

    static boolean  checkBSTInOrder(Node root) {

        ArrayList<Integer> arr=new ArrayList<Integer>();
        inOrder(root,arr);

        for(int i=1;i<arr.size();i++)
            if(arr.get(i)>arr.get(i-1))
                continue;
            else
                return false;
        return true;

    }

    static boolean  checkBST(Node root) {

        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    private static boolean check(Node root, int minValue, int maxValue) {
        if(root == null){return  true;}
        if(root.data <= minValue || root.data >= maxValue)
        {
            return false;
        }
        return check(root.left,minValue,root.data) && check(root.right, root.data,maxValue);
    }


    public static void inOrder(Node root, ArrayList<Integer> arr)
    {
        if(root == null) return;
        inOrder(root.left,arr);
        arr.add(root.data);
        inOrder(root.right,arr);
    }

    public static void main(String [] args)
    {
        Node root = new Node(4);

        root.insert(2);
        //root.insert(6);
        root.insert(1);
        root.insert(3);
        root.insert(5);
        //root.insert(7);
        root.insert(2);

        System.out.println(checkBST(root));

        //System.out.println(Integer.MIN_VALUE +" " +Integer.MAX_VALUE);
    }
}


