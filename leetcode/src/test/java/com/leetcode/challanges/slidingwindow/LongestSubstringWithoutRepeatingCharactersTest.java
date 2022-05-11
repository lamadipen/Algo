package com.leetcode.challanges.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void lengthOfLongestSubstringTest1() {
        int actual = LongestSubstringWithoutRepeatingCharactersSolution.findLengthOfLongestRepeatingCharacters("abcabcbb");
        Assertions.assertEquals(3,actual);
    }

    @Test
    void lengthOfLongestSubstringTest2() {
        int actual = LongestSubstringWithoutRepeatingCharactersSolution.findLengthOfLongestRepeatingCharacters("bbbbb");
        Assertions.assertEquals(1,actual);
    }

    @Test
    void lengthOfLongestSubstringTest3() {
        int actual = LongestSubstringWithoutRepeatingCharactersSolution.findLengthOfLongestRepeatingCharacters("pwwkew");
        Assertions.assertEquals(3,actual);
    }
}