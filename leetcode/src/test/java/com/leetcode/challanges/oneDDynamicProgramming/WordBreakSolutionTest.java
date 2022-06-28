package com.leetcode.challanges.oneDDynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WordBreakSolutionTest {

    @Test
    void wordBreakTest1() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean actual = WordBreakSolution.wordBreakDfs("leetcode", wordDict);
        Assertions.assertEquals(true, actual);
    }

    @Test
    void wordBreakTest2() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean actual = WordBreakSolution.wordBreakDfs("applepenapple", wordDict);
        Assertions.assertEquals(true, actual);
    }

    @Test
    void wordBreakTest3() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean actual = WordBreakSolution.wordBreakDfs("catsandog", wordDict);
        Assertions.assertEquals(false, actual);
    }

    @Test
    void wordBreakTest4() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean actual = WordBreakSolution.wordBreak("leetcode", wordDict);
        Assertions.assertEquals(true, actual);
    }

    @Test
    void wordBreakTest5() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean actual = WordBreakSolution.wordBreak("applepenapple", wordDict);
        Assertions.assertEquals(true, actual);
    }

    @Test
    void wordBreakTest6() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean actual = WordBreakSolution.wordBreak("catsandog", wordDict);
        Assertions.assertEquals(false, actual);
    }
}