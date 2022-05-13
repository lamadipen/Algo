package com.leetcode.challanges.bitmanipulation;
/**
 * Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 * */
public class SumofTwoIntegersSolution {

    /**
     * Runtime O(logb) from geeks of geeks
     * Space Complexity O(1)
     * */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // don't miss the brackets, it's better to do in 2 steps.
            a = (a ^ b);
            b = carry;
        }
        return a;
    }
    /**
     * Above code does the same as this one it is just elaborating the above method
     *
     * */
    static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    static int AddRecursive(int x, int y)
    {
        if (y == 0)
            return x;
        else
            return Add(x ^ y, (x & y) << 1);
    }

}
