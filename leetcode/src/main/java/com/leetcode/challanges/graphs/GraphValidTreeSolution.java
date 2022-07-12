package com.leetcode.challanges.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Graph Valid Tree
 *
 * */
public class GraphValidTreeSolution {

    /**
     * O(n + e) where n is number of nodes and e is number of edges
     *
     * */
    public static boolean isValidTree(int n, int[][] edges){

        List<List<Integer>> adjancyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjancyList.add(new ArrayList<>());
        }

        for (int[] edge :edges) {
            int e1 = edge[0];
            int e2 = edge[1];

            adjancyList.get(e1).add(e2);
            adjancyList.get(e2).add(e1);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(0,adjancyList,visited,-1) && visited.size() == n;
    }

    private static boolean dfs(int node, List<List<Integer>> adjancyList, Set<Integer> visited, int previousNode) {
        if(visited.contains(node)) return false;

        visited.add(node);

        for (int neighbor : adjancyList.get(node)) {
            if(neighbor == previousNode) continue;

            if(!dfs(neighbor, adjancyList, visited,node)){
                return false;
            }
        }
        return  true;
    }
}
