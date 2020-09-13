package kata.sortingandsearching;

public class QuickSort {
    public void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    private void sort(int[] input, int start, int end) {
        int index = partation(input, start, end);
        if (start < index - 1) {
            sort(input, start, index - 1);
        }
        if (index < end) {
            sort(input, index, end);
        }
    }

    private int partation(int[] input, int start, int end) {
        int pivot = input[(start + end) / 2];
        while (start <= end) {
            while (input[start] < pivot) {
                start++;
            }

            while (input[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(input, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private void swap(int[] input, int start, int end) {
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
    }
}
