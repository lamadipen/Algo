package com.leetcode.challanges.slidingwindow;

/**
 * Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStockSolution {
    /**
     * Runtime O(n^2)
     * Space Complexity O(1)
     */
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    continue;
                } else {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }
        return maxProfit;
    }

    /**
     *  Runtime O(n)
     *  Space Complexity O(1)
     */
    public static int maxProfitOptimized(int[] prices) {
        int maxProfit = 0;

        int slowIndex = 0;
        int fastIndex = 1;

        while (fastIndex < prices.length) {
            if (prices[slowIndex] >= prices[fastIndex]) {
                slowIndex = fastIndex;
                fastIndex++;
            } else {
                int profit = prices[fastIndex] - prices[slowIndex];
                maxProfit = Math.max(profit, maxProfit);
                fastIndex++;
            }
        }
        return maxProfit;
    }

    /**
     *  Runtime O(n)
     *  Space Complexity O(1)
     */
    public static int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < buy) {
                buy = price;
            }
            else {
                sell = Math.max(sell, price - buy);
            }
        }
        return sell;
    }

}

