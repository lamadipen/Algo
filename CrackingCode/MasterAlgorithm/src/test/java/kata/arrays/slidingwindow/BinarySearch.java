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

        int actual3 = binarySearchIterative(input, 10);
        Assert.assertEquals(-1, actual3);
    }

    public int binarySearchIterative(int[] input, int target) {
        int start = 0;
        int end = input.length -1;

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

    @Test
    public void binarySearchRecursiveTest() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int actual = binarySearchRecursive(input, 2);
        Assert.assertEquals(1, actual);

        int actual1 = binarySearchRecursive(input, 9);
        Assert.assertEquals(8, actual1);

        int actual2 = binarySearchRecursive(input, 0);
        Assert.assertEquals(-1, actual2);

        int actual3 = binarySearchRecursive(input, 10);
        Assert.assertEquals(-1, actual3);
    }

    public int binarySearchRecursive(int[] input, int target) {
        return binarySearchRecursive(input, target, 0, input.length - 1);
    }

    public int binarySearchRecursive(int[] input, int target, int start, int end) {
        if (end >= start) {
            int mid = (start + end) / 2;
            if (input[mid] == target) {
                return mid;
            }

            if (target < input[mid]) {
                return binarySearchRecursive(input, target, start, mid - 1);
            }

            if (target > input[mid]) {
                return binarySearchRecursive(input, target, mid + 1, end);
            }
        }
        return -1;
    }
}

