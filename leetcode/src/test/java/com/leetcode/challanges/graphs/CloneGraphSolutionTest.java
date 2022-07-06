package com.leetcode.challanges.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphSolutionTest {

    @Test
    void cloneGraph() {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        Node actual = CloneGraphSolution.cloneGraph(node1);

        Assertions.assertEquals(node1.val,actual.val);
        Assertions.assertEquals(node1.neighbors.size(),actual.neighbors.size());
        Assertions.assertFalse(node1 == actual);
    }
}