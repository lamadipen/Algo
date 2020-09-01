package kata.sortingandsearching;

public class MergeSort {
    public void sort(int[] input) {
        int length = input.length;

        if (length < 2) {
            return;
        }

        int mid = length / 2;

        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = input[i];
        }

        for (int i = mid; i < length; i++) {
            right[i - mid] = input[i];
        }

        sort(left);
        sort(right);
        merge(left, right, input);
    }

    private void merge(int[] left, int[] right, int[] input) {
        int leftStart = 0;
        int rightStart = 0;
        int index = 0;
        int leftLength = left.length;
        int rightLength = right.length;

        while (leftStart < leftLength && rightStart < rightLength) {
            if (left[leftStart] <= right[rightStart]) {
                input[index] = left[leftStart];
                leftStart++;
            } else {
                input[index] = right[rightStart];
                rightStart++;
            }
            index++;
        }

        while (leftStart < leftLength) {
            input[index] = left[leftStart];
            index++;
            leftStart++;
        }

        while (rightStart < rightLength) {
            input[index] = right[rightStart];
            index++;
            rightStart++;
        }
    }
}
