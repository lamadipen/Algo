package com.leetcode.challanges.twoDDynamicProgramming;


/**
 * Unique Paths
 * https://leetcode.com/problems/unique-paths/
 *
 * */
public class UniquePathsSolution {
    /**
     * Runtime O(m-1 * n -1 + m +n) => O(m-1 * n -1)
     * Space Complexity O(m * n)
     *
     * */
    public static  int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //fill the bottom row
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }

        //fill the right most col
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n-2; col >=0; col--) {
                dp[row][col] = dp[row][col+1] + dp[row+1][col];
            }
        }

        return dp[0][0];
    }
}

