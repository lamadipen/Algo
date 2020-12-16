package kata.moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Moderate
 * SumSwap
 * CC: pg 184 Q: 16.21
 */
public class SumSwapSolution {

    /**
     * Runtime O(m*n) where m and n are length of two arrays
     * This solution will have multiple solution but returns the first
     * occuring solution.
     */
    public int[] findSwapValues(int[] arr1, int[] arr2) {
        int sum1 = calculateTotalSum(arr1);
        int sum2 = calculateTotalSum(arr2);

        for (int a1 : arr1) {
            for (int a2 : arr2) {
                int newSum1 = sum1 - a1 + a2;
                int newSum2 = sum2 - a2 + a1;

                if (newSum1 == newSum2) {
                    int[] values = {a1, a2};
                    return values;
                }
            }
        }
        return null;
    }

    private int calculateTotalSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    /**
     * Runtime O(m*n) where m and n are length of two arrays
     * This solution will have multiple solution but returns the first
     * occuring solution.
     */
    public int[] findSwapValuesTargetApproach(int[] arr1, int[] arr2) {
        Integer target = getTarget(arr1, arr2);
        if (null == target) {
            return null;
        }

        for (int a1 : arr1) {
            for (int a2 : arr2) {
                if (a1 - a2 == target) {
                    int[] values = {a1, a2};
                    return values;
                }
            }
        }
        return null;
    }

    private Integer getTarget(int[] arr1, int[] arr2) {
        int sum1 = calculateTotalSum(arr1);
        int sum2 = calculateTotalSum(arr2);

        if ((sum1 - sum2) % 2 != 0) {
            return null;
        }
        return (sum1 - sum2) / 2;
    }

    /**
     * Runtime O(m + n) where m and n are length of two arrays
     * This solution will have multiple solution but returns the first
     * occuring solution.
     */
    public int[] findSwapValuesTargetOptimized(int[] arr1, int[] arr2) {
        Integer target = getTarget(arr1, arr2);
        if (null == target) {
            return null;
        }
        return findDifference(arr1, arr2, target);
    }

    private int[] findDifference(int[] arr1, int[] arr2, Integer target) {
        Set<Integer> setOfArr2 = convertToSet(arr2);
        for (int value : arr1) {
            int delta = value - target;
            if (setOfArr2.contains(delta)) {
                return new int[]{value, delta};
            }
        }
        return null;
    }

    private Set<Integer> convertToSet(int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr2) {
            set.add(value);
        }
        return set;
    }

    /**
     * Runtime O(m logm + n logn) where m and n are length of two arrays.
     * As arrays need to be sorted
     * This solution will have multiple solution but returns the first
     * occuring solution.
     */
    public int[] findSwapValuesTargetOptimizedNoExtraSpaceRequired(int[] arr1, int[] arr2) {
        Integer target = getTarget(arr1, arr2);
        if (null == target) {
            return null;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return findDifferenceNoExtraSpaceRequired(arr1, arr2, target);
    }

    private int[] findDifferenceNoExtraSpaceRequired(int[] arr1, int[] arr2, Integer target) {
        int a = 0;
        int b = 0;

        while (a < arr1.length && b < arr2.length) {
            int difference = arr1[a] - arr2[b];
            /**
             * Compare the difference to target if the difference is to small, then make it
             * bigger by moving a to a bigger value. If it is too big, then make it smaller
             * by moving b to a bigger value.  If it's just right, return this pair
             * */
            if (difference == target) {
                return new int[]{arr1[a], arr2[b]};
            } else if (difference < target) {
                a++;
            } else {
                b++;
            }
        }
        return null;
    }
}
