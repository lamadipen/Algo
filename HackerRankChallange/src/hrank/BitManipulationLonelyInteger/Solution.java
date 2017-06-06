package hrank.BitManipulationLonelyInteger;

/**
 * Created by dipen on 5/30/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int lonelyInteger(int[] a) {

        if(a.length == 1)
        {
            return a[0];
        }
        else
        {
            int value = 0;

            for (int i : a) {
                value ^= i;
            }
            return value;
        }


    }

    public static void main(String[] args) {
        System.out.println("Binary of 10 " +Integer.toBinaryString(10));
        System.out.println("Binary of -10 " +Integer.toBinaryString(-10));
        System.out.println("Binary of 8 "+Integer.toBinaryString(8));
        System.out.println(10 | 8);
        System.out.println(10 & 8);
        System.out.println(10 ^ 8);
        System.out.println(10 << 1);
        System.out.println(10 >> 1);

        System.out.println("Creating Mask");
        System.out.println(44&(1 <<5));
        System.out.println(44|(1 <<5));
        System.out.println(44&~(1 <<5));


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //System.out.println(lonelyInteger(a));
        System.out.println(10 | 10);
    }
}

/**
 Input 0
 1
 1

 output 0
 1

 Input 1
 3
 1 1 2

 output 1
 2

 Input 2
 5
 0 0 1 2 1

 output 2
 2
 **/

/** 1) Any number xor'd with itself will give zero.
 *  2) Any number xor'd with zero will give the number.
 *  3) We are told there is an odd number of numbers in
 *  the array and they are all pairs of the same number, apart from one.
 So if we xor all the numbers in the array together then any which are the same
 will cancel out - and give zero as the result of all the xors.
 Then we are left with the unique number, which xor's with zero and so
 gives the unique number as the answer.**/