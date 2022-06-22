package com.leetcode.challanges.oneDDynamicProgramming;

import java.util.Arrays;

/**
 * Coin Change
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChangeSolution {
    /**
     * Runtime O(c * a) where c is size of coins and a is size of amount
     * space complexity O(a)
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1 || amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount +1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i - coin >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return dp[amount] != amount +1 ? dp[amount] : -1 ;
    }
}
