package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

/*
https://leetcode.com/problems/decompress-run-length-encoded-list/

* */
public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int finalArrSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            finalArrSize += key;
            i++;
        }
        int[] finalArr = new int[finalArrSize];
        int finalArrIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int value = nums[i+1];
            for (int k=0; k < key; k++){
                finalArr[finalArrIndex++] = value;
            }
            i++;
        }
        return finalArr;
    }

    @Test
    public void decompressRLElistTest() {
        int[] result = decompressRLElist(new int[]{1, 2, 3, 4});
        Assert.assertArrayEquals(new int[]{2, 4, 4, 4}, result);
    }


    @Test
    public void decompressRLElistTestVersion2() {
        int[] result = decompressRLElist(new int[]{1, 2, 3, 4});
        Assert.assertArrayEquals(new int[]{2, 4, 4, 4}, result);
    }


    public int[] decompressRLElistVersion2(int[] nums) {
        int finalArrSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            finalArrSize += key;
            i++;
        }
        int[] finalArr = new int[finalArrSize];
        int finalArrIndex = 0;

        for (int i = 0; i < nums.length/2; i+=2) {
            int key = nums[2*i];
            int value = nums[2*i+1];
            for (int k=0; k < key; k++){
                finalArr[finalArrIndex++] = value;
            }
        }
        return finalArr;
    }
}
