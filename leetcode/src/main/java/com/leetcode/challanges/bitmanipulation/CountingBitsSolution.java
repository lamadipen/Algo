package com.leetcode.challanges.bitmanipulation;
/**
 * Counting Bits
 * https://leetcode.com/problems/counting-bits/
 * */
public class CountingBitsSolution {
    public static int[] countBits(int n) {

        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] =count(i);
        }
        return ans;
    }

    private static int count(int x) {
        int count =0;

        while (x != 0) {
            x &= x-1;
            count++;
        }
        return count;
    }
}
