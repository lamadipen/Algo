package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * Find N Unique Integers Sum up to Zero
 * <p>
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 * Example 1:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: [0]
 * <p>
 * Constraints:
 * 1 <= n <= 1000
 */
public class FindNUniqueIntegersSumUptoZero {

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int index = 0;
        if (n % 2 != 0) {
            arr[0] = 0;
            index = 1;
        }
        for (int i = index; i < arr.length; i++) {
            arr[i++] = i;
            arr[i] = -i;
        }
        return arr;
    }

    @Test
    public void sumZeroTest() {
        assertSumZero(sumZero(3), 3);
        assertSumZero(sumZero(4), 4);
    }

    private void assertSumZero(int[] ints, int length) {
        Assert.assertEquals(0, sumAllElements(ints));
        Assert.assertEquals(length, ints.length);
    }

    private int sumAllElements(int[] ints) {
        return Arrays.stream(ints).sum();
    }
}
