package hrank.DFSConnectedCellinaGrid;

/**
 * Created by dipen on 6/6/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }

    public static int getBiggestRegion(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, countCells(matrix, i, j));
            }
        }
        return max;
    }

    private static int countCells(int[][] matrix, int i, int j) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
            return 0;

        if(matrix[i][j] == 0)
            return 0;

        int count = matrix[i][j]--;
          /* similart to code above
        int count = 1;
        matrix[i][j] = 0;
        */
        count += countCells(matrix,i+1,j);
        count += countCells(matrix,i-1,j);
        count += countCells(matrix,i,j+1);
        count += countCells(matrix,i,j-1);
        count += countCells(matrix,i+1,j+1);
        count += countCells(matrix,i-1,j-1);
        count += countCells(matrix,i-1,j+1);
        count += countCells(matrix,i+1,j-1);

        return  count;
    }
}

/**
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
 * **/

/** solution without altering orginal array
 public static int getBiggestRegion(int[][] matrix) {
 boolean[][] visited = new boolean[matrix.length][matrix[0].length];
 int bigRegion = 0;
 int size = 0;
 for (int row = 0; row < matrix.length; row++) {
 for (int col = 0; col < matrix[0].length; col++) {
 if (!visited[row][col]) {
 size = findRegion(matrix, visited, row, col);
 bigRegion = Math.max(bigRegion, size);
 }
 }
 }
 return bigRegion;
 }

 private static int findRegion(int[][] matrix, boolean[][] visited, int row, int col) {
 if (row >= matrix.length || col >= matrix[0].length) return 0;
 if (row < 0 || col < 0) return 0;
 int count = 0;
 if (visited[row][col]) return 0;
 visited[row][col] = true;
 if (matrix[row][col] == 0) {
 return 0;
 }
 count = 1;
 count += findRegion(matrix, visited, row + 1, col);
 count += findRegion(matrix, visited, row, col + 1);
 count += findRegion(matrix, visited, row + 1, col + 1);
 count += findRegion(matrix, visited, row - 1, col);
 count += findRegion(matrix, visited, row, col - 1);
 count += findRegion(matrix, visited, row - 1, col - 1);
 count += findRegion(matrix, visited, row - 1, col + 1);
 count += findRegion(matrix, visited, row + 1, col - 1);
 return count;
 }
 **/