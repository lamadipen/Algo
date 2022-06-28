package com.leetcode.challanges.oneDDynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break
 * https://leetcode.com/problems/word-break/
 */
public class WordBreakSolution {

/**
 * Runtime O(n^2 * w) where n is length of string and w is length of wordDict.
 *
 * */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(wordDictSet.contains(s.substring(j,i)) && dp[j]){
                  dp[i] = true;
                  break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * Runtime O(w^2 * s) where w is length of wordDict and s is length of string
     * Space Complexity O(s)
     */
    public static boolean wordBreakDfs(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length() + 1];
        return dfs(s, wordDict, cache, 0);
    }

    private static boolean dfs(String s, List<String> wordDict, Boolean[] cache, int index) {
        if (index == s.length()) return true;
        if (cache[index] != null) return cache[index];

        boolean result = false;

        for (String word : wordDict) {
            if (s.substring(index).startsWith(word)) {
                result = dfs(s, wordDict, cache, index + word.length());
            }
        }
        cache[index] = result;
        return result;

    }
}
