package kata.moderate;

import java.util.Arrays;

/**
 * Moderate
 * SmallestDifference
 * CC: pg 181 Q: 16.6
 */
public class SmallestDifference {
    /**
     * Runtime O(n^2) where n is number of inputs
     */
    public Pair getSmallestDifferenceBruteForce(int[] arr1, int[] arr2) {
        int min = Integer.MAX_VALUE;
        Pair pair = null;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int newMin = Math.min(min, Math.abs(arr1[i] - arr2[j]));
                if (newMin < min) {
                    min = newMin;
                    pair = new Pair(arr1[i], arr2[j]);
                }
            }
        }
        return pair;
    }

    /**
     * Runtime O(nlogn + mlogm) where n and m  is number of inputs
     */
    public Pair getSmallestDifference(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int min = Integer.MAX_VALUE;

        Pair pair = null;
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < arr1.length && bIndex < arr2.length) {
            int newMin = Math.min(min, Math.abs(arr1[aIndex] - arr2[bIndex]));
            if (newMin < min) {
                min = newMin;
                pair = new Pair(arr1[aIndex], arr2[bIndex]);
            }
        }
        return pair;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}