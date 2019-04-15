package com.dp.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> unqiue = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < length && j < length) {
            if (!unqiue.contains(s.charAt(j))) {
                unqiue.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                unqiue.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        ;
        //Assert.assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        //Assert.assertEquals(3,lengthOfLongestSubstring("pwwkew"));
        //Assert.assertEquals(2,lengthOfLongestSubstring("aab"));

    }


    public int ascii128Solution(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
