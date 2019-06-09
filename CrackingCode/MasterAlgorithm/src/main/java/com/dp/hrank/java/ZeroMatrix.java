package com.dp.hrank.java;

public class ZeroMatrix {
    public static void main(String... args) {
        int[][] matrix = new int[3][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
//       matrix[0][2] = 3;
        matrix[1][0] = 9;
        matrix[1][1] = 8;
//        matrix[1][2] = 7;
        matrix[2][0] = 0;
        matrix[2][1] = 6;
//        matrix[2][2] = 4;

        System.out.println("Matrix length " +matrix.length);
        System.out.println("Matrix [0] length " +matrix[0].length);
        zeroMatrix(matrix);
        /*
        1 9 0
        2 8 6
        3 7 4
        */

    }

    public static void zeroMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++){
//                if(matrix[j][i] == 0){
//                    row[j] = true;
//                    column[i] = true;
//                }
//            }
//        }
//
//        for(int i =0; i < row.length; i++){
//            if(row[i]){
//                nullifyRow(matrix, i);
//            }
//        }
//
//        for(int i= 0; i < column.length; i++){
//            if(column[i]){
//                nullifyColumn(matrix, i);
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println(" ");
//        }

    }

    private static void nullifyRow(int[][] matrix, int row) {
        for(int j =0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }
}
