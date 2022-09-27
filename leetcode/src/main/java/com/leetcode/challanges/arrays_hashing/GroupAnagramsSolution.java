package com.leetcode.challanges.arrays_hashing;

import java.util.*;

/**
 * Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * https://www.youtube.com/watch?v=vzdNOK2oB2E
 * */
public class GroupAnagramsSolution {

    /**
     * Runtime O(n*slogs) where n is number of strings in input array and s is length of individual string
     * Space Complexity O(n + M)
     * */

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : strs) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String str = new String(wordArray);

            if (anagramMap.get(str) == null) {
                anagramMap.put(str, new ArrayList<>());
            }
            anagramMap.get(str).add(word);
        }
        result.addAll(anagramMap.values());
        return result;
    }

    /**
     * Runtime O(n*s*26) where n is number of strings in input array and s is length of individual string and
     * 26 is number of lowercase characters in english alphabet
     * Space Complexity O(n + n)
     * */
    public static List<List<String>> groupAnagramsOptimal(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0) return result;
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word: strs) {
            char[] hash = new char[26];
            for (char letter : word.toCharArray()) {
                hash[letter -'a']++;
            }
            String str = new String(hash);

            if (anagramMap.get(str) == null) {
                anagramMap.put(str, new ArrayList<>());
            }
            anagramMap.get(str).add(word);
        }

        result.addAll(anagramMap.values());
        return result;
    }
}
