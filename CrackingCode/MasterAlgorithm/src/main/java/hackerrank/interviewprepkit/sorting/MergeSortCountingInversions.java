package hackerrank.interviewprepkit.sorting;

/**
 * Interview Preparation Kit | Sorting | MergeSort Counting Inversions
 * MergeSort Counting Inversions
 */
public class MergeSortCountingInversions {

    public static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int count = 0;
        int mid = (start + end) / 2;
        count += mergeSort(array, start, mid);
        count += mergeSort(array, mid + 1, end);
        count += merge(array, start, end);
        return count;
    }

    private static long merge(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        int[] newArray = new int[end - start + 1];

        int current = 0;
        int leftStart = start;
        int rightStart = mid + 1;

        long count = 0;

        while (leftStart <= mid && rightStart <= end) {
            if (array[leftStart] > array[rightStart]) {
                newArray[current++] = array[rightStart++];
                count += mid - leftStart + 1;
            } else {
                newArray[current++] = array[leftStart++];
            }
        }

        while (leftStart <= mid) {
            newArray[current++] = array[leftStart++];
        }

        while (rightStart <= end) {
            newArray[current++] = array[rightStart++];
        }
        System.arraycopy(newArray, 0, array, start, end - start + 1);

        return count;
    }

}
