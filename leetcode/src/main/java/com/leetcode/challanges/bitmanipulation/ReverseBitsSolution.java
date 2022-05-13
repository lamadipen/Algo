package com.leetcode.challanges.bitmanipulation;
/**
* Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 *
 * https://www.youtube.com/watch?v=UcoN6UjAI64
 * https://www.youtube.com/watch?v=-5z9dimxxmI
* */
public class ReverseBitsSolution {

    public static int reverseBits(int n) {
        int result =0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            result  = result | (bit << (31-i));
        }
        return result;
    }

}
