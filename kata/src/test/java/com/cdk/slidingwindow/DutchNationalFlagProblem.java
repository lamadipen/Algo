package com.cdk.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    @Test
    public void solution(){
        int[] arr = {5, 2, 4, 4, 6, 4, 4, 3};
        int[] expected = {3, 2, 4, 4, 4, 4, 6, 5};
        int p = 4;
        createDutchFlag(arr, p);
        System.err.println(Arrays.toString(arr));
        Assert.assertArrayEquals(expected, arr);

    }

    private void createDutchFlag(int[] arr, int value) {
        int pointer1 = 0;
        int pointer2 = arr.length -1 ;

        for (int i = pointer1; i < pointer2; i++) {
            if (arr[pointer1] > value && arr[pointer2] <= value) {
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer1++;
                pointer2--;
            }else{
                pointer1++;
            }
        }
    }
}
