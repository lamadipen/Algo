package kata.recursiondynamicprogramming;

/**
 * Recursion and dynamic programming
 * Magic Index
 * CC: pg 135 Q: 8.3
 */
public class MagicIndex {

    /**
     * Runtime of solution is O(n) where n is number of items in array
     * This solution cannot handle duplicate
     *
     * @param array sorted array without duplicate
     * @return int index of the element
     */
    public int getMagicIndexBruteForce(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Runtime of solution is O(logn) where n is number of items in array
     * This solution cannot handle duplicate
     *
     * @param array sorted array without duplicate
     * @return int index of the element
     */
    public int getMagicIndexOptimized(int[] array) {

        return getMagicIndexOptimized(array, 0, array.length - 1);
    }

    private int getMagicIndexOptimized(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (array[mid] == mid) {
            return mid;
        } else if (mid > array[mid]) {
            return getMagicIndexOptimized(array, mid + 1, end);
        } else {
            return getMagicIndexOptimized(array, start, mid - 1);
        }
    }

    public int getMagicIndexHandleDuplicateOptimized(int[] array) {

        return getMagicIndexHandleDuplicateOptimized(array, 0, array.length - 1);
    }

    private int getMagicIndexHandleDuplicateOptimized(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }
        //search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = getMagicIndexHandleDuplicateOptimized(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = getMagicIndexHandleDuplicateOptimized(array, rightIndex, end);
        return right;
    }


}
