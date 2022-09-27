package com.leetcode.challanges.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Number of Connected Components in Graph
 * https://www.youtube.com/watch?v=8f1XPm4WOUc
 * Union Fined Best Scenario for this kind of problem
 * */
public class NumberOfConnectedComponentsInGraphSolution {
    /**
     * Runtime O(n + e) where n is number of nodes and e is number of edges.
     * */
    public static int numOfConnectedComponent(int n, int[][] edges){

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge:edges) {
            int e1 = edge[0];
            int e2 = edge[01];

            adjacencyList.get(e1).add(e2);
            adjacencyList.get(e2).add(e1);
        }

        Set<Integer> visited = new HashSet<>();
        int numOfConnectedComponent =0;
        for (int i = 0; i < n; i++) {
            if(!visited.contains(i)){
                numOfConnectedComponent++;
                dfs(i,adjacencyList,visited);
            }
        }

        return  numOfConnectedComponent;
    }

    private static void dfs(int node, List<List<Integer>> adjacencyList, Set<Integer> visited) {
        if(visited.contains(node))return;

        visited.add(node);
        for (int neighbor: adjacencyList.get(node)) {
            dfs(neighbor,adjacencyList,visited);
        }
    }

    public static int unionFindSolution(int n, int[][] edges){
        int[] parents = new int[n];
        int[] ranks = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int result = n;

        for (int[] edge: edges) {
            result  -= union(edge[0], edge[1], parents, ranks);
        }
        
        return result;
    }

    private static int union(int node1, int node2, int[] parents, int[] ranks) {
        int parent1 = find(node1, parents);
        int parent2 = find(node2, parents);

        if(parent1 == parent2) return 0;

        if (ranks[parent2] > ranks[parent1]) {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        } else {
            parents[parent2] = parent1;
            ranks[parent1] += parent2;
        }
        return 1;
    }

    private static int find(int node, int[] parents) {
        int result = node;

        while (result != parents[result]){
            parents[result] = parents[parents[result]];
            result = parents[result];
        }
        return result;
    }


}
