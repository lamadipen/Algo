package com.leetcode.challanges.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Search
 * https://leetcode.com/problems/word-search/
 *
 * https://www.youtube.com/watch?v=pfiQ_PS1g8E
 */
public class WordSearchSolution {

    /**
     * Runtime (r * c * 4^w) where w is length of word and r, c is row and col length
     * */
    public static boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(dfs(board, row, col, 0, word)){
                    return  true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int row, int col, int wordIndex, String word) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(wordIndex)) {
            return false;
        }

        boolean exists = false;
        if (board[row][col] == word.charAt(wordIndex)) {
            board[row][col] +=100;
            exists = dfs(board, row, col + 1, wordIndex + 1, word) ||
                    dfs(board, row, col - 1, wordIndex + 1, word) ||
                    dfs(board, row + 1, col, wordIndex + 1, word) ||
                    dfs(board, row - 1, col, wordIndex + 1, word);
            board[row][col] -=100;
        }
        return  exists;
    }
}
