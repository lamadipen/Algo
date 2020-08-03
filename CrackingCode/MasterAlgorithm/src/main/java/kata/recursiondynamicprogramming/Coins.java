package kata.recursiondynamicprogramming;

/**
 * Recursion and dynamic programming
 * Coins
 * CC: pg 136 Q: 8.11
 */
public class Coins {
    public int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) {
            return 1;
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int remainingAmount = amount - i * denomAmount;
            ways += makeChange(remainingAmount, denoms, index + 1);
        }
        return ways;
    }
}
