package com.leetcode.challanges.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTimetoBuyandSellStockSolutionTest {

    @Test
    void maxProfitTest1() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfitBruteForce(new int[]{7, 1, 5, 3, 6, 4});
        Assertions.assertEquals(5,actual);
    }

    @Test
    void maxProfitTest2() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfitOptimized(new int[]{7, 1, 5, 3, 6, 4});
        Assertions.assertEquals(5,actual);
    }


    @Test
    void maxProfitTest3() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfitOptimized(new int[]{7, 2, 5, 3,1, 6, 4});
        Assertions.assertEquals(5,actual);
    }

    @Test
    void maxProfitTest4() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfitOptimized(new int[]{7, 2, 3, 5, 6, 1, 4});
        Assertions.assertEquals(4,actual);
    }

    @Test
    void maxProfitTest5() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assertions.assertEquals(5,actual);
    }


    @Test
    void maxProfitTest6() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfit(new int[]{7, 2, 5, 3,1, 6, 4});
        Assertions.assertEquals(5,actual);
    }

    @Test
    void maxProfitTest7() {
        int actual = BestTimetoBuyandSellStockSolution.maxProfit(new int[]{7, 2, 3, 5, 6, 1, 4});
        Assertions.assertEquals(4,actual);
    }
}