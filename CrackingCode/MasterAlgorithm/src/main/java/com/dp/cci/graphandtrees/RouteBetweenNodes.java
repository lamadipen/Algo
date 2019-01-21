package com.dp.cci.graphandtrees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by dipen on 1/17/2019.
 * Route between nodes
 * Page 241
 * Question 4.1
 * Given : Directed Graph
 * Then : find out whether there is a route between two nodes
 */
public class RouteBetweenNodes {
    public boolean search(Graph graph,Node start, Node end){
        if(start == end) return true;
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(start);

        Node temp;

        while(!queue.isEmpty()){
            temp = queue.removeFirst();
            visited.add(temp);
            if(temp != null){
                for (Node node: temp.getAdjacent()) {
                    if(!visited.contains(node)){
                        if(node == end) {
                            return true;
                        }else {
                            queue.add(node);
                        }
                    }
                }
            }
        }
        return false;
    }
}