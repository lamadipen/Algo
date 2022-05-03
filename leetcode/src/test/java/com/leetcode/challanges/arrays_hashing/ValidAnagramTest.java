package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @Test
    void isAnagramTest1() {
        boolean actual = ValidAnagram.isAnagram("anagram","nagaram");
        Assertions.assertEquals(true,actual);
    }

    @Test
    void isAnagramTest2() {
        boolean actual = ValidAnagram.isAnagram("rat","car");
        Assertions.assertEquals(false,actual);
    }
}