package com.leetcode.challanges.arrays_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class GroupAnagramsSolutionTest {

    @Test
    void groupAnagramsTest1() {
        List<List<String>> actual = GroupAnagramsSolution.groupAnagramsOptimal(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"tan", "nat"}));
        expected.add(Arrays.asList(new String[]{"eat", "tea", "ate"}));
        expected.add(Arrays.asList(new String[]{"bat"}));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void groupAnagramsTest2() {
        List<List<String>> actual = GroupAnagramsSolution.groupAnagramsOptimal(new String[]{""});

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{""}));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void groupAnagramsTest3() {
        List<List<String>> actual = GroupAnagramsSolution.groupAnagramsOptimal(new String[]{"a"});

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"a"}));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void groupAnagramsTest4() {
        List<List<String>> actual = GroupAnagramsSolution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"eat", "tea", "ate"}));
        expected.add(Arrays.asList(new String[]{"bat"}));
        expected.add(Arrays.asList(new String[]{"tan", "nat"}));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void groupAnagramsTest5() {
        List<List<String>> actual = GroupAnagramsSolution.groupAnagrams(new String[]{""});

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{""}));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void groupAnagramsTest6() {
        List<List<String>> actual = GroupAnagramsSolution.groupAnagrams(new String[]{"a"});

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"a"}));

        Assertions.assertEquals(expected,actual);
    }
}