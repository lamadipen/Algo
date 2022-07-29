package com.leetcode.challanges.mathgeometry;

import java.util.ArrayList;
import java.util.List;
/**
 * Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 * */
public class SpiralMatrixSolution {
    /**
     * Runtime O(n*m) where n is row length and m is col length
     *
     * */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length -1;

        int top =0;
        int bottom = matrix.length -1;

        List<Integer> result = new ArrayList<>();


        while (left <= right && top <= bottom){
            //get every element in top row
            for (int index = left; index <= right; index++) {
                result.add(matrix[top][index]);
            }
            top++;

            //get every element in the right col
            for (int index = top; index <= bottom; index++) {
                result.add(matrix[index][right]);
            }
            right--;
            //check we still can go through the array
            if(left < right && top < bottom){

                //get every element in the bottom row
                for (int index = right -1; index >= left; index--) {
                    result.add(matrix[bottom][index]);
                }
                bottom--;

                //get every element in the left col
                for (int index = bottom ; index >= top; index--) {
                    result.add(matrix[index][left]);
                }
                left++;

            }else{
                break;
            }
        }

        return result;
    };
}
