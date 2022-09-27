package com.leetcode.challanges.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * https://www.youtube.com/watch?v=oobqoCJlHA0
* */
public class ImplementTrieSolution
{
    /**
     * In the given scenario we will be having 26 lowercase alphabets so the max 1st level nodes will be 26 that why
     * it can be considered as constatn time O(1)
     * */
    static class Trie {
        TriesNode root;
        public Trie() {
            root = new TriesNode();
        }

        /**
         * Runtime O(w) where w is world length;
         * */
        public void insert(String word) {
            TriesNode current = root;
            for (Character c : word.toCharArray()) {
                if(!current.children.containsKey(c)){
                    current.children.put(c, new TriesNode());
                }
                current = current.children.get(c);
            }
            current.endOfWord = true;
        }


        /**
         * Runtime O(w) where w is world length;
         * */
        public boolean search(String word) {
            TriesNode current = root;

            for (Character c : word.toCharArray()) {
                if(!current.children.containsKey(c)){
                    return false;
                }
                current = current.children.get(c);
            }

            return current.endOfWord;
        }


        /**
         * Runtime O(w) where w is world length;
         * */
        public boolean startsWith(String prefix) {
            TriesNode current = root;

            for (Character c : prefix.toCharArray()) {
                if(!current.children.containsKey(c)){
                    return false;
                }
                current = current.children.get(c);
            }

            return true;
        }
    }
}


class TriesNode{
    Map<Character, TriesNode> children;
    boolean endOfWord;

    public TriesNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}


