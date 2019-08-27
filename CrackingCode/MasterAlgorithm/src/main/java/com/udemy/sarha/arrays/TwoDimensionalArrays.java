package com.udemy.sarha.arrays;

import java.util.Arrays;

//http://math.hws.edu/javanotes/c7/s5.html
public class TwoDimensionalArrays {
    //Two Dimension Array
    public static void twoDimensionalArrayBasic() {
        int[][] A = new int[2][3];
        A[0][0] = 10;
        A[0][1] = 11;
        A[0][2] = 12;
        A[1][0] = 12;
        A[1][1] = 12;
        A[1][2] = 12;

        System.out.println("Before the loop:: " + A.length);

        for (int i = 0; i < A.length; i++) {
            System.out.println();
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + ",");
            }
        }

        int[][] B = {{1, 0, 12, -1},
                {7, -3, 2, 5},
                {-5, -2, 2, -9}
        };
        System.out.println("");
        System.out.println("B[0] row:: " + Arrays.toString(B[0]));
    }


    public static void matrix(){
        int[][] matrix = new int[7][];// rows has not been yet created

        for(int i=0; i < matrix.length; i++){
            matrix[i] = new int[i+1]; // Create row i with i + 1 elements.
        }

    }


    public static void main(String[] args) {
        twoDimensionalArrayBasic();
    }
}
