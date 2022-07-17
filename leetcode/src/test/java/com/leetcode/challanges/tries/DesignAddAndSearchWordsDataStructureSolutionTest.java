package com.leetcode.challanges.tries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DesignAddAndSearchWordsDataStructureSolutionTest {

    @Test
    public void test(){
        DesignAddAndSearchWordsDataStructureSolution.WordDictionary wordDictionary = new DesignAddAndSearchWordsDataStructureSolution.WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertFalse(wordDictionary.search("pad"));   // return False
        Assertions.assertTrue(wordDictionary.search("bad"));   // return True
        Assertions.assertTrue(wordDictionary.search(".ad"));   // return True
        Assertions.assertTrue(wordDictionary.search("b.."));   // return True
    }

}