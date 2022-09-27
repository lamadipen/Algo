package com.leetcode.challanges.oneDDynamicProgramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Decode Ways
 * https://leetcode.com/problems/decode-ways/
 *
 * https://www.youtube.com/watch?v=6aEyTjOwlJU
 */
public class DecodeWaysSolution {
    public static List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());

    /**
     * Runtime O(n)
     * Space complexity O(n)
     *
     */
    public static int numDecodings(String s) {
        int[] memo = new int[s.length()];
        return dfs(0, memo, s);
    }

    private static int dfs(int index, int[] memo, String s) {
        if (index == s.length()) return 1;
        if (memo[index] != 0) return memo[index];

        int ways = 0;

        for (String prefix : LETTERS) {
            if (s.substring(index).startsWith(prefix)) {
                ways += dfs(index + prefix.length(), memo, s);
            }
        }
        memo[index] = ways;
        return memo[index];
    }
}
