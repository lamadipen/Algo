package com.leetcode.challanges.graphs;

import java.util.*;

/**
 * Clone Graph
 * https://leetcode.com/problems/clone-graph/
 *
 * https://www.youtube.com/watch?v=mQeF6bN8hMk
 * */
public class CloneGraphSolution {
    /**
     * Runtime O(e + v) where e is number of edges and v is number of vertex
     *
     * */
    public static Node cloneGraph(Node node) {
        if(node == null) return  node;

        //Key = Original Node, Value = Clone Node
        Map<Node, Node> map = new HashMap<>();

        //Needed for bfs
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node cloneHead = new Node(node.val, new ArrayList<>());
        map.put(node, cloneHead);

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();

            for (Node neighbor: currentNode.neighbors) {
                //if the node is not already cloned
                if(!map.containsKey(neighbor)){
                    Node cloneNeighbor = new Node(neighbor.val, new ArrayList<>());
                    map.put(neighbor, cloneNeighbor);
                    queue.add(neighbor);
                }

                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return cloneHead;
    }
}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}