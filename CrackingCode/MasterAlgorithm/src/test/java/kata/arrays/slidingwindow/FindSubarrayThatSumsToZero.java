package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given array of integer, find subarray that sums to zero
 *Input: [2,4,-2,1,-3,5,-3]
 * Output: [4,-2,1,3]
 * */
public class FindSubarrayThatSumsToZero {
    @Test
    public void findSubarrayThatSumsToZero() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int[] expected = {4, -2, 1, 3};
        int pointer1 = 0;
        int pointer2 = 0;
        int[] sumArr = new int[input.length];
        sumArr[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            sumArr[i] = sumArr[i - 1] + input[i];
        }
        int tempSum = input[pointer1];
        for (int i = pointer1; i > 0; i--) {
            tempSum = input[i] - input[i - 2];
            if(tempSum == 0){
                pointer1 = i;
                break;
            }
        }

        int[] subArr = new int[(pointer2 - pointer1)+1];
        int pointer = 0;
        for (int i = pointer1; i < pointer2; i++) {
            subArr[pointer++] = input[i];
        }

        Assert.assertArrayEquals(expected, subArr);

    }
}
