package com.leetcode.challanges.advancedGraph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionarySolutionTest {

    @Test
    void alienOrderTest1() {
        String actual = AlienDictionarySolution.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
        Assertions.assertEquals("wertf",actual);
    }

    @Test
    void alienOrderTest2() {
        String actual = AlienDictionarySolution.alienOrder(new String[]{"z","x"});
        Assertions.assertEquals("zx",actual);
    }
}