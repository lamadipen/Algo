package com.leetcode.challanges.tries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImplementTrieSolutionTest {
    @Test
    public void test(){
        ImplementTrieSolution.Trie trie = new ImplementTrieSolution.Trie();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));   // return True
        Assertions.assertFalse(trie.search("app"));   // return False
        Assertions.assertTrue(trie.startsWith("app"));   // return True

        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));   // return True

    }
}