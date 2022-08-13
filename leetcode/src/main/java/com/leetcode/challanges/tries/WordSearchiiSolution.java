package com.leetcode.challanges.tries;

import java.util.*;
import java.util.stream.Collectors;

/**
 * word-search-ii
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchiiSolution {
    /**
    * Runtime O(m*n*4^w) where m is row, n is col and 4 is number of possible paths and w is length of word in trie
    * */
    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            root.addWord(word);
        }

        int rowLength = board.length;
        int colLength = board[0].length;
        Set<String> result = new HashSet<>();
        Set<Pair> visited = new HashSet<>();


        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                dfs(board,row,col,root,visited,"", result);
            }
        }

        return result.stream().collect(Collectors.toList());
    }

    private static void dfs(char[][] board, int row, int col, TrieNode trieNode, Set<Pair> visited, String word, Set<String> result) {
        if(row < 0 || col < 0 || row == board.length || col == board[0].length
                || visited.contains(new Pair(row,col))
                || !trieNode.children.containsKey(board[row][col])
        ) return;

        visited.add(new Pair(row, col));
        TrieNode childNode = trieNode.children.get(board[row][col]);
        word+= board[row][col];

        if(childNode.endOfWord){
            result.add(word);
        }

        dfs(board,row-1,col,childNode,visited,word, result);
        dfs(board,row+1,col,childNode,visited,word, result);
        dfs(board,row,col-1,childNode,visited,word, result);
        dfs(board,row,col+1,childNode,visited,word, result);

        visited.remove(new Pair(row,col));
    }


}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }

    public void addWord(String s) {
        TrieNode current = this;
        for (char c : s.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.endOfWord = true;
    }
}

class Pair{
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row && col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}