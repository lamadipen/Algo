package com.leetcode.challanges.mathgeometry;

import java.util.Arrays;

/**
 * Rotate Image
 * https://leetcode.com/problems/rotate-image
 **/

public class RotateImageSolution {
    /**
     * Runtime O(n^2)
     * */
    public static void rotate(int[][] matrix) {

        int left =0;
        int right = matrix.length-1;

        while (left < right) {
            for (int index = 0; index <= right-1; index++) {
                int top = left;
                int bottom = right;

                //save the topleft
                int topleft = matrix[top][left+index];

                //move bottom left in top left
                matrix[top][left+index] = matrix[bottom-index][left];

                //move bottom right into bottom left
                matrix[bottom-index][left] = matrix[bottom][right-index];

                //move top right into bottom right
                matrix[bottom][right -index] = matrix[top +index][right];

                //move top left into top right
                matrix[top + index][right] = topleft;

            }
            right--;
            left++;
        }

        System.out.println("Rotated ");
        Arrays.stream(matrix).forEach(row -> {
            for (int r:row) {
                System.out.print(r +" ");
            }
            System.out.println("");
        });
    }


    public static void rotateV2(int[][] matrix) {
        int length = matrix.length;
        transpose(matrix,length);
        reverse(matrix, length);
        System.out.println("Rotated  V2");
        Arrays.stream(matrix).forEach(row -> {
            for (int r:row) {
                System.out.print(r +" ");
            }
            System.out.println("");
        });
    }

    private static void transpose(int[][] matrix, int length) {
        for (int row = 0; row < length; row++) {
            for (int col = row+1; col < length; col++) {
                int temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }

    private static void reverse(int[][] matrix, int length) {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length/2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][length -1 - col];
                matrix[row][length -1 - col]= temp;
            }
        }
    }
}
