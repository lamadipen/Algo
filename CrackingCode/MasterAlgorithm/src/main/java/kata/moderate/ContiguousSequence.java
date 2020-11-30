package kata.moderate;

/**
 * Moderate
 * Contiguous Sequence
 * CC: pg 183 Q: 16.17
 */
public class ContiguousSequence {
    public int getContiguousMaxSum(int[] arr) {
        int sum = 0;
        //In case we need negative max number set the maxSum to intital value of array
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = arr[i] + sum;
            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < arr[i]) {
                sum = arr[i];
            }
        }
        return maxSum;
    }
}
