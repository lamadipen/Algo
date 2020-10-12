package kata.sortingandsearching.peaksAndValley;

import java.util.Arrays;

/**
 * Check Sorting and Searching:
 * Peak and Valley
 * CC: pg 151 Q: 10.11
 * <p>
 * Runtime nlog(n) n => number of elements
 */
public class PeaksAndValleySolution1 {
    public void sortPeakValley(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            swap(array, i);
        }
    }

    private void swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i - 1];
        array[i - 1] = temp;
    }
}
