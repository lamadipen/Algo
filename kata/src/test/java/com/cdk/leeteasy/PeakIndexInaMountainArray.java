package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

/**
 Peak Index in a Mountain Array

 Let's call an array A a mountain if the following properties hold:

 A.length >= 3
 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

 Example 1:

 Input: [0,1,0]
 Output: 1
 Example 2:

 Input: [0,2,1,0]
 Output: 1
 Note:

 3 <= A.length <= 10000
 0 <= A[i] <= 10^6
 A is a mountain, as defined above.

  */
public class PeakIndexInaMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        if(A.length < 3){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    @Test
    public void peakIndexInMountainArrayTest(){
        Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,1,0}));
        Assert.assertEquals(2,peakIndexInMountainArray(new int[]{0,1,2,0}));
    }

}
