package com.leetcode.challanges.mathgeometry;
/**
 * Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * https://www.youtube.com/watch?v=T41rL0L3Pnw
 * */
public class SetMatrixZeroesSolution {
    /**
     * Runtime O(n*m)
     * Space complexity O(1)
     * */
    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length -1;
        int colLength = matrix[0].length -1;

        boolean isFirstRowZero = false;

        /**
         * use first row and col as marker to fill 0 in all corrosponding row and col
         * position matrix[0][0] is shared so define a variable to track row
         * and use position matrix[0][0] to track col
         * */
        for (int row = 0; row <= rowLength; row++) {
            for (int col = 0; col <= colLength; col++) {
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;

                    if(row == 0){
                        isFirstRowZero = true;
                    }else {
                        matrix[row][0] =0;
                    }
                }
            }
        }

        //fill all row and col except first row and first col
        for (int row = 1; row <= rowLength; row++) {
            for (int col = 1; col <= colLength; col++) {
                if(matrix[0][col]  == 0 || matrix[row][0] == 0){
                    matrix[row][col] =0;
                }
            }
        }

        //fill first column
        if(matrix[0][0] == 0){
            for (int row = 0; row <= rowLength; row++) {
                matrix[row][0] = 0;

            }
        }

        //fill first row
        if(isFirstRowZero){
            for (int col = 0; col <= colLength; col++) {
                matrix[0][col] =0;
            }
        }
    }
}
