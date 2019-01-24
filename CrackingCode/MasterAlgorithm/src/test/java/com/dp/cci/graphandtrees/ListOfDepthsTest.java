package com.dp.cci.graphandtrees;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Created by dipen on 1/22/2019.
 */
public class ListOfDepthsTest {

    private ListOfDepths listOfDepths;
    private TreeNode root, node1, node2, node3, node4, node5, node6;

    @Before
    public void setUp() {
        listOfDepths = new ListOfDepths();
        root = new TreeNode(10);
        node1 = new TreeNode(5);
        node2 = new TreeNode(15);
        node3 = new TreeNode(2);
        node4 = new TreeNode(8);
        node5 = new TreeNode(14);
        node6 = new TreeNode(18);

        root.leftNode = node1;
        node1.leftNode = node3;
        node1.rightNode = node4;

        root.rightNode = node2;
        node2.leftNode = node5;
        node2.rightNode = node6;
    }

    @Test
    public void createLevelLinkedList_DFS_Test() {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
        listOfDepths.createLevelLinkedList_DFS(root, list, 0);

        list.stream()
                .forEach(linkList -> {
                    System.out.println(linkList);
                    linkList.forEach(node -> System.out.print(node.getData() + " ,"));
                    System.out.println();
                });
    }
}