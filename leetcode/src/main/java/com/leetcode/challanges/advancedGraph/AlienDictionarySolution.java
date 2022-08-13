package com.leetcode.challanges.advancedGraph;

import java.util.*;

/**
 * alien-dictionary
 * https://www.lintcode.com/problem/892/?fromId=207&_from=collection
 *
 */
public class AlienDictionarySolution {

    /**
     * Runtime O(l*w) where l is size of word list and w is length of minimum word
     * Space Complexity O(l)
     * */
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjacencyList = new HashMap<>();

        for (int i = 0; i < words.length -1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                char word1Char = word1.charAt(j);
                char word2Char = word2.charAt(j);

                if(word1Char != word2Char){
                    if(!adjacencyList.containsKey(word1Char)){
                        adjacencyList.put(word1Char, new HashSet<>());
                        adjacencyList.get(word1Char).add(word2Char);
                    }else{
                        adjacencyList.get(word1Char).add(word2Char);
                    }
                    break;
                }
            }
        }

        Map<Character, Boolean> visited = new HashMap<>();
        List<Character> result = new ArrayList<>();

        for (Character c: adjacencyList.keySet()) {
            if(dfs(c,adjacencyList,visited,result)){
                return  "";
            }
        }

        String strResult="";
        for (int i = result.size() -1; i >= 0 ; i--) {
            strResult += result.get(i);
        }
        return strResult;
    }

    private static boolean dfs(char character, Map<Character, Set<Character>> adjacencyList, Map<Character, Boolean> visited, List<Character> result) {
        if(visited.containsKey(character)) return visited.get(character);
        visited.put(character,true);

        Set<Character> adjList = adjacencyList.containsKey(character)? adjacencyList.get(character): Collections.emptySet();
        for (Character neighbor : adjList) {
            if(dfs(neighbor, adjacencyList,visited,result)) return true;
        }

        visited.put(character,false);
        result.add(character);
        return false;
    }
}
