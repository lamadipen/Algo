package com.udemy.sarha.arrays;

/**
 * http://math.hws.edu/javanotes/c7/s5.html
 *
 * Represents symmetric n-by-n matrices of real numbers.
 *
 */
public class SymmetricMatrix {
    private double[][] matrix; //A triangular matrix to hold the data.

    /*creates a n-by-n symemetric matrix in which all entries are 0*/
    public SymmetricMatrix(int n){
        matrix = new double[n][];
        for(int i=0; i< n; i++){
            matrix[i] = new double[i+1];
        }
    }
    /*Returns the matrix entry at position (row,col).
    * (IF row < col, the value is actually stored at position (col,row)*/
    public double get(int row, int col){
        if(row > col){
            return matrix[row][col];
        }else{
            return matrix[col][row];
        }
    }
    /*sets the value of the matrix entry at (row,col)
    * (If row < col, the value is actually stored at position (col,row)*/
    public void set(int row, int col, double value) {
        if(row >= col){
            matrix[row][col] = value;
        }else{
            matrix[col][row] = value;
        }
    }

    /*return the number of rows and colums in the matrix*/
    public int size() {
        return matrix.length; // the size is the number of rows
    }

}
