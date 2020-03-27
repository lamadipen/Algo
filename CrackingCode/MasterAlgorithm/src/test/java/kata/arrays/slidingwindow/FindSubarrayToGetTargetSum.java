package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

/**
 * Find the sub array to get the target sum
 * input [1,2,3,5,2]
 * Max sum 8
 * Result [ 3,5]
 * */
public class FindSubarrayToGetTargetSum {

    @Test
    public void findSubarrayToGetTargetSum() {
        int[] input = {1, 2, 3, 5, 2};
        int[] expected = {3, 5};

        int pointer1 =0;
        int pointer2 = 1;
        int target = 8;
        int sum = input[pointer1];

        for (int i = pointer2; i < input.length; i++) {
            sum = sum + input[i];
            pointer2 =i;
            while (sum > target) {
                sum -= input[pointer1++];
            }
            if (sum == target) {
                break;
            }
        }

        int[] actuals = new int[(pointer2-pointer1)+1];
        int pointer3=0;
        for (int i = pointer1; i <= pointer2; i++) {
            actuals[pointer3++] = input[i];
        }


        Assert.assertArrayEquals(expected, actuals);
    }

}