package com.leetcode.challanges.graphs;

/**
 * Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * https://www.youtube.com/watch?v=pV2kpPD66nE
 */
public class NumberOfIslandsSolution {
    /**
     * Runtime O(n^2)
     * */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rLength = grid.length;
        int cLength = grid[0].length;
        int totalIlands = 0;

        for (int row = 0; row < rLength; row++) {
            for (int col = 0; col < cLength; col++) {
                if (grid[row][col] == '1') {
                    totalIlands++;
                    dfs(grid, row, col);
                }
            }
        }

        return totalIlands;
    }

    private static void dfs(char[][] grid, int row, int col) {
        int rLength = grid.length;
        int cLength = grid[0].length;

        if (row < 0 || row >= rLength || col < 0 || col >= cLength || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }
}
