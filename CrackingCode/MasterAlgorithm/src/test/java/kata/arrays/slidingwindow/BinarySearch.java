package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {
    @Test
    public void binarySearchIterativeTest() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int actual = binarySearchIterative(input, 1);
        Assert.assertEquals(0, actual);

        int actual1 = binarySearchIterative(input, 9);
        Assert.assertEquals(8, actual1);

        int actual2 = binarySearchIterative(input, 0);
        Assert.assertEquals(-1, actual2);
    }

    public int binarySearchIterative(int[] input, int target) {
        int start = 0;
        int end = input.length;

        while (end >= start) {
            int mid = (start + end) / 2;

            if (input[mid] == target) {
                return mid;
            }

            if (target < input[mid]) {
                end = mid - 1;
            }

            if (target > input[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
