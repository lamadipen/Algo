package com.leetcode.challanges.graphs;

import java.util.*;

/**
 * Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlowSolution {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowLength = heights.length;
        int colLength = heights[0].length;

        Set<Pair> pacific = new HashSet<>();
        Set<Pair> atlantic = new HashSet<>();


        for (int row = 0; row < rowLength; row++) {
            dfs(row, 0, pacific, heights[row][0], heights);
            dfs(row, colLength -1, atlantic, heights[row][colLength -1], heights);
        }

        for (int col = 0; col < rowLength; col++) {
            dfs(0, col, pacific, heights[0][col], heights);
            dfs(rowLength -1, col, atlantic, heights[rowLength-1][col], heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                Pair pair = new Pair(row, col);
                if(pacific.contains(pair) && atlantic.contains(pair)){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(row);
                    arrayList.add(col);
                    result.add(arrayList);
                }
            }
        }
        
        return result;
    }

    private static void dfs(int row, int col, Set<Pair> visited, int previousHeight, int[][] heights) {
        int rowLength = heights.length;
        int colLength = heights[0].length;
        if (row < 0 || row == rowLength || col < 0 || col == colLength || visited.contains(new Pair(row, col)) || heights[row][col] < previousHeight)
            return;

        visited.add(new Pair(row, col));
        dfs(row + 1, col, visited, heights[row][col], heights);
        dfs(row - 1, col, visited, heights[row][col], heights);
        dfs(row, col + 1, visited, heights[row][col], heights);
        dfs(row, col - 1, visited, heights[row][col], heights);
    }
}


class Pair {
    int row;
    int col;

    public Pair() {
    }

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row && col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
