package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given the array of integer, find continuous  subarray with maximum sum
 * input [-2, -3, 4, -1, -2, 1, 5, -1]
 * Max sum 7
 * Result [ 4, -1, -2, 1, 5]
 * */
public class FindSubarrayWithMaxSumTest {

    @Test
    public void findMaxSumSubArray() {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -1};
        int[] expected = {4, -1, -2, 1, 5};

        int[] sums = new int[input.length];
        sums[0] = input[0];

        for (int i = 1; i < input.length; i++) {
            int tempSum = input[i] + sums[i - 1];

            if (tempSum > input[i]) {
                sums[i] = tempSum;
            }else {
                sums[i] = input[i];
            }
        }
        int pointer1 = 0;
        int pointer2 = 0;
        int maxSum = sums[0];

        for (int i = 0; i < input.length; i++) {
            if (sums[i] > maxSum) {
                if (sums[i] == input[i]) {
                    pointer1 = i;
                    pointer2 = i;
                }else{
                    pointer2 = i;
                }
                maxSum = sums[i];
            }
        }

        int[] actuals = new int[(pointer2-pointer1)+1];
        int pointer3=0;
        for (int i = pointer1; i <= pointer2; i++) {
            actuals[pointer3++] = input[i];
        }

        Assert.assertArrayEquals(expected, actuals);
        Assert.assertEquals(7, maxSum);
    }

}