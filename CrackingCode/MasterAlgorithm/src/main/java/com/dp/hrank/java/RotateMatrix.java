package com.dp.hrank.java;

public class RotateMatrix {
    public static void main(String... args) {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[1][0] = 2;
        matrix[2][0] = 3;
        matrix[3][0] = 4;
        matrix[0][1] = 12;
        matrix[1][1] = 13;
        matrix[2][1] = 14;
        matrix[3][1] = 5;
        matrix[0][2] = 11;
        matrix[1][2] = 16;
        matrix[2][2] = 15;
        matrix[3][2] = 6;
        matrix[0][3] = 10;
        matrix[1][3] = 9;
        matrix[2][3] = 8;
        matrix[3][3] = 7;

        System.out.println("Before Rotation");

        for(int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j] + "  ");
            }
            System.out.print(" ");
        }

        matrix = rotateMatrix(matrix);
        System.out.println("After Rotation");
        for(int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j] + "  ");
            }
            System.out.print(" ");
        }

        //int[][] matrix = {{0,0},{1,0},{2,0},{3,0}};
        System.out.println(matrix.length);
        System.out.println(matrix[2].length);

    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int mLength = matrix.length;

        if (mLength == 0 || matrix.length != matrix[0].length) {
            return null;
        }

        for (int layer = 0; layer < mLength / 2; layer++) {
            int first = layer;
            int last = mLength - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                //top -> right
                matrix[i][last]  = top; // right <- saved top

            }

        }

        return matrix;
//        if(mLength == matrix)
    }
}
