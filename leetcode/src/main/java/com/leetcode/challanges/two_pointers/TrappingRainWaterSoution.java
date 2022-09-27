package com.leetcode.challanges.two_pointers;
/**
 * Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * https://www.youtube.com/watch?v=ZI2z5pq0TqA
 * */
public class TrappingRainWaterSoution {
    public static int getTrappedRainWater(int[] arr) {
        int[] leftSize = new int[arr.length];
        int[] rightSize = new int[arr.length];
        int maxHeight = arr[0];
        int count =0;

        for (int i = 0; i < arr.length; i++) {
            leftSize[i] = Math.max(arr[i], maxHeight) ;
            maxHeight = leftSize[i];
        }

        maxHeight = arr[arr.length-1];

        for (int i =arr.length-1; i >= 0; i--){
            rightSize[i] = Math.max(arr[i], maxHeight);
            maxHeight = rightSize[i];
        }


        for (int i =0; i < arr.length;i++){
            count = count + Math.min(leftSize[i],rightSize[i]) - arr[i];
        }
        return count;
    }


    public static int getTrappedRainWaterTwoPointer(int[] arr) {
        int left =0;
        int right = arr.length -1;

        int leftMax = arr[left];
        int rightMax = arr[right];

        int result = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                result += leftMax - arr[left];
            }else{
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                result += rightMax - arr[right];
            }
        }
        return result;

    }

}
