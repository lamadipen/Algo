package com.leetcode.challanges.tries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchiiSolutionTest {

    @Test
    void findWordsTest1() {
        List<String> actual = WordSearchiiSolution
                .findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});

        Assertions.assertEquals("oath",actual.get(0));
        Assertions.assertEquals("eat",actual.get(1));
    }

    @Test
    void findWordsTest2() {
        List<String> actual = WordSearchiiSolution
                .findWords(new char[][]{{'a','b'}, {'c','d'}}, new String[]{"abcb"});

        Assertions.assertTrue(actual.isEmpty());
    }
}