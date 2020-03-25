package com.cdk.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ReArrangeAllZero {
    @Test
    public void reArrangeZeros() {
        int[] arr = {4, 2, 0, 1, 0, 3, 0};
        int[] expected = {0, 0, 0, 1, 2, 3,4};
//        int[] expected = {0, 0, 0, 4, 1, 2, 3};
        int pointer1 = 0;
        int pointer2 = 1;

        //sliding window  O(n)
        //alternative sort the array O(nlogn)
        for (int i = pointer2; i < arr.length; i++) {
            if (arr[pointer2] == 0) {
                int temp = arr[pointer2];
                arr[pointer2] = arr[pointer1];
                arr[pointer1] = temp;
                pointer1++;
            }
            pointer2++;
        }

        System.err.println(Arrays.toString(arr));
        Assert.assertArrayEquals(expected,arr);


    }
}
