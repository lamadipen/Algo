package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;
//Need to fix it
/**
 * Given an array of positive and negative integer find sub array where sum x
 */
public class FindSubArrayThatSumToTarget {


    public int[] findSubArrayThatSumToTarget(int[] input, int target) {
        int pointer1 = 0;
        int pointer2 = 0;
        int sum = input[0];

        for (int i = 1; i < input.length - 1; i++) {
            if (input[i] == target) {
                pointer1 = i;
                pointer2 = i;
                break;
            }
            sum = sum + input[i];

            if (sum > target) {
                pointer1 = i;
                pointer2 = i;
                sum = input[i];
            }
            if (sum == target) {
                pointer2 = i;
                break;
            }
        }

        int[] actual;
        if (pointer1 == pointer2) {
            actual = new int[1];
            actual[0] = input[pointer1];
        } else {
            actual = new int[(pointer2 - pointer1) + 1];
            int pointer = 0;
            for (int i = pointer1; i <= pointer2; i++) {
                actual[pointer++] = input[i];
            }
        }
        return actual;
    }

    @Test
    public void findSubArrayThatSumToTargetTestFindExactMatch() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int target = -2;
        int[] subArrayThatSumToTarget = findSubArrayThatSumToTarget(input, target);
        Assert.assertArrayEquals(new int[]{-2}, subArrayThatSumToTarget);
    }

    @Test
    public void findSubArrayThatSumToTargetTestFindExactMatch2() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int target = -3;
        int[] subArrayThatSumToTarget = findSubArrayThatSumToTarget(input, target);
        Assert.assertArrayEquals(new int[]{-3}, subArrayThatSumToTarget);
    }

    @Test
    public void findSubArrayThatSumToTargetTestFindSumMatch1() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int target = 6;
        int[] subArrayThatSumToTarget = findSubArrayThatSumToTarget(input, target);
        Assert.assertArrayEquals(new int[]{2,4}, subArrayThatSumToTarget);
    }

    @Test
    public void findSubArrayThatSumToTargetTestFindSumMatch2() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int target = 7;
        int[] subArrayThatSumToTarget = findSubArrayThatSumToTarget(input, target);
        Assert.assertArrayEquals(new int[]{2, 4, -2, 1, -3, 5}, subArrayThatSumToTarget);
    }

    @Test
    public void findSubArrayThatSumToTargetTestFindSumMatch3() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int target =-1;
        int[] subArrayThatSumToTarget = findSubArrayThatSumToTarget(input, target);
        Assert.assertArrayEquals(new int[]{-2, 1}, subArrayThatSumToTarget);
    }

    @Test
    public void findSubArrayThatSumToTargetTestFindSumMatch4() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int target =0;
        int[] subArrayThatSumToTarget = findSubArrayThatSumToTarget(input, target);
        Assert.assertArrayEquals(new int[]{4,-2, 1,-3}, subArrayThatSumToTarget);
    }


}
