package kata.sortingandsearching.peaksAndValley;

/**
 * Check Sorting and Searching:
 * Peak and Valley
 * CC: pg 151 Q: 10.11
 * <p>
 * Runtime O(n) => number of elements
 */
public class PeaksAndValleySolution2 {
    public void sortPeakValley(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int maxPeakIndex = maxPeekIndex(array, i - 1, i, i + 1);
            swap(array, i, maxPeakIndex);
        }
    }

    private void swap(int[] array, int index, int maxPeakIndex) {
        int temp = array[index];
        array[index] = array[maxPeakIndex];
        array[maxPeakIndex] = temp;
    }

    private int maxPeekIndex(int[] array, int previous, int current, int next) {
        int length = array.length;

        int previousValue = previous >= 0 && previous < length ? array[previous] : Integer.MIN_VALUE;
        int currentValue = current >= 0 && current < length ? array[current] : Integer.MIN_VALUE;
        int nextValue = next >= 0 && next < length ? array[next] : Integer.MIN_VALUE;

        int maxPeakValue = Math.max(previousValue, Math.max(currentValue, nextValue));

        if (maxPeakValue == previousValue) {
            return previous;
        } else if (maxPeakValue == currentValue) {
            return current;
        } else {
            return next;
        }
    }
}
