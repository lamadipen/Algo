package kata.sortingandsearching;

public class BinarySearch {
    public int binarySearchRecursive(int[] input, int target) {
        return binarySearchRecursive(input, 0, input.length - 1, target);
    }

    private int binarySearchRecursive(int[] input, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = input[mid];

        if (target < midValue) {
            return binarySearchRecursive(input, start, mid - 1, target);
        } else if (target > midValue) {
            return binarySearchRecursive(input, mid + 1, end, target);
        } else {
            return mid;
        }
    }

    public int binarySearchIterative(int[] input, int target) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = input[mid];

            if (midVal == target) {
                return mid;
            }
            if (target < midVal) {
                end = mid - 1;
            }
            if (target > midVal) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
