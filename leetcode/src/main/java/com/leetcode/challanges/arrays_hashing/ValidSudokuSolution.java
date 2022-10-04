package com.leetcode.challanges.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *  Valid Sudoku
 *  https://leetcode.com/problems/valid-sudoku/
 *
 *  https://www.youtube.com/watch?v=TjFXEUCMqI8&feature=emb_logo
 * */
public class ValidSudokuSolution {
    /**
     * Runtime
     * Spacecomplexity
     * */
    public boolean isValidSudoku(char[][] board) {

        int rowLength = board.length;
        int colLength = board[0].length;

        Set<Character> rowSet;
        Set<Character> colSet;


        //check for rows
        //run time O(r * c)
        for (int i = 0; i < rowLength; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < colLength; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if(rowSet.contains(board[i][j])){
                    return false;
                }
                rowSet.add(board[i][j]);
            }
        }

        //check for cols
        //runtime O(c *r)
        for(int i=0; i < colLength; i++){
            colSet = new HashSet<>();
            for (int j =0; j < rowLength; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                if(colSet.contains(board[j][i])){
                    return false;
                }
                colSet.add(board[j][i]);
            }
        }

        //block check

        for(int row =0; row < rowLength; row =row +3){
            for (int col=0; col < colLength; col =col+3){
                if(!checkBlock(row, col, board)){
                    return false;
                }
            }
        }

        return  true;
    }

    private boolean checkBlock(int row, int col, char[][] board) {
        Set<Character> blockSet = new HashSet<>();

        int rows = row +3;
        int cols = col +3;

        for(int i=row; i < rows; i++){
            for (int j =col; j < cols; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(blockSet.contains(board[i][j])){
                    return false;
                }
            }
        }

        return true;
    }
}
