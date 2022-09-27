package com.leetcode.challanges.arrays_hashing;

import java.util.Arrays;

/**
 * Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * https://www.youtube.com/watch?v=bNvIQI2wAjk
 */
public class ProductOfArrayExceptSelfSolution {
    /**
     * Runtime O(n) where n is length of input array
     * Space Complexity O(n + n) => O(n)
     * */
    public static int[] productExceptSelf(int[] nums) {
        int inputLength = nums.length;

        int[] prefix = new int[inputLength];
        int[] postfix = new int[inputLength];


        for (int i = 0; i < inputLength; i++) {
            if (i == 0) {
                prefix[i] = 1 * nums[i];
            } else {
                prefix[i] = prefix[i-1] * nums[i];
            }
        }

        for (int i = inputLength-1; i >=0 ; i--) {
            if (i == inputLength - 1) {
                postfix[i] = nums[i] * 1;
            }else{
                postfix[i] = nums[i] *postfix[i+1];
            }
        }

        int[] result = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            if (i == 0) {
                result[i] = 1 * postfix[i+1];

            }else if(i== inputLength-1){
                result[i] = 1*prefix[i-1];
            }else{
                result[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return result;
    }


    /**
     * Runtime O(n) where n is length of input array
     * Space Complexity O(1) since only variable was used for this algorithm
     * */
    public static int[] productExceptSelfOptimized(int[] nums) {
        int inputLength = nums.length;
        int[] result = new int[inputLength];

        Arrays.fill(result,1);

        int prefix=1;
        // Perform Prefix product operation by traversing Left -> Right
        for (int i = 0; i < inputLength; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix=1;
        for (int i = inputLength-1; i >= 0 ; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }

}
