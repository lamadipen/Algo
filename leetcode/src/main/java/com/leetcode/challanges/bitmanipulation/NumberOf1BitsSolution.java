package com.leetcode.challanges.bitmanipulation;
/**
 *  Number of 1 Bits
 *  https://leetcode.com/problems/number-of-1-bits/
 *
 *  https://www.youtube.com/watch?v=5Km3utixwZs
 * */
public class NumberOf1BitsSolution {

/**
 * Runtime O(32) as integer is 32 bit long and with this approach we have to traverse each bit.
 *
 * */
    public static int hammingWeight(int n) {
        int result =0;
        while (n!=0){
            result += n%2;
            n = n >>1;
        }
        return result;
    }

    /**
     * Runtime O(32) as integer is 32 bit long and with this approach we have to traverse each bit.
     *
     * */
    public static int hammingWeightOptimized(int n) {
        int result =0;
        while (n!=0){
            n = n & (n-1);
            result +=1;
        }
        return result;
    }

}
