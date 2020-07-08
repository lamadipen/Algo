package kata.recursiondynamicprogramming;

import java.util.Arrays;

/**
 * Recursion and dynamic programming
 * TripleStep
 * CC: pg 1134 Q: 8.1
 */
public class TripleStep {
    public int calculateWays(int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            return calculateWays(target - 1) + calculateWays(target - 2) + calculateWays(target - 3);
        }
    }

    public int calculateWaysMemoization(int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        return calculateWaysMemoization(target, cache);
    }

    public int calculateWaysMemoization(int target, int[] cache) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (cache[target] > -1) {
            return cache[target];
        } else {
            cache[target] = calculateWaysMemoization(target - 1, cache)
                    + calculateWaysMemoization(target - 2, cache)
                    + calculateWaysMemoization(target - 3, cache);
            return cache[target];
        }
    }
}
