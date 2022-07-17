package com.leetcode.challanges.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
* */
public class DesignAddAndSearchWordsDataStructureSolution
{
    /**
     * In the given scenario we will be having 26 lowercase alphabets so the max 1st level nodes will be 26 that why
     * it can be considered as constatn time O(1)
     * */
    static class WordDictionary {
        DictionaryNode root;
        public WordDictionary() {
            root = new DictionaryNode();
        }

        /**
         * Runtime O(w) where w is world length;
         * */
        public void addWord(String word) {
            DictionaryNode current = root;
            for (Character c : word.toCharArray()) {
                if(!current.children.containsKey(c)){
                    current.children.put(c, new DictionaryNode());
                }
                current = current.children.get(c);
            }
            current.endOfWord = true;
        }


        /**
         * Runtime O(w) where w is world length;
         * */
        public boolean search(String word) {
            return dfs(0, word, root);
        }

        private boolean dfs(int index, String word, DictionaryNode dictionaryNode) {
            DictionaryNode current = dictionaryNode;

            char[] charArray = word.toCharArray();
            for (int i = index; i < word.length(); i++) {
                Character c = charArray[i];
                if (c.equals('.')) {
                    for (DictionaryNode child : current.children.values()) {
                        if(dfs(i +1, word, child)) return true;
                        else return false;
                    }
                } else {
                    if (!current.children.containsKey(c)) {
                        return false;
                    }
                }
                current = current.children.get(c);
            }

            return current.endOfWord;
        }
    }
}


class DictionaryNode {
    Map<Character, DictionaryNode> children;
    boolean endOfWord;

    public DictionaryNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}


