package kata.moderate;

/**
 * Moderate
 * Sub Sort
 * CC: pg 183 Q: 16.16
 */
public class SubSortSolution {

    public void findUnorderedSequence(int[] arr) {
        //find end of left sorted sequence
        int leftEnd = findEndOfLeftSequence(arr);
        if (leftEnd >= arr.length) return; // already sorted array

        //find start of right sorted sequence
        int rightStart = findStartOfRightSequence(arr);

        //find out maxIndex and minIndex
        int maxIndex = leftEnd;
        int minIndex = rightStart;

        for (int i = leftEnd + 1; i < rightStart; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }

            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        //slide left until less than array[min_index]
        int leftIndex = shrinkLeft(arr, minIndex, leftEnd);

        //slide right until greater than array[max_index]
        int rightIndex = shrinkRight(arr, maxIndex, rightStart);

        System.out.println(leftIndex + " " + rightIndex);
    }

    private int shrinkRight(int[] arr, int maxIndex, int rightStart) {
        int comp = arr[maxIndex];
        for (int i = rightStart; i < arr.length; i++) {
            if (arr[i] >= comp) {
                return i - 1;
            }
        }
        return 0;
    }

    private int shrinkLeft(int[] arr, int minIndex, int leftEnd) {
        int comp = arr[minIndex];
        for (int i = leftEnd - 1; i > 0; i--) {
            if (arr[i] <= comp) return i + 1;
        }
        return 0;
    }

    public int findStartOfRightSequence(int[] arr) {
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public int findEndOfLeftSequence(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return i - 1;
            }
        }
        return arr.length - 1;
    }
}
