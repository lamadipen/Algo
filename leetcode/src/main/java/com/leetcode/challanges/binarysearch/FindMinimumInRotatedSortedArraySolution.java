package com.leetcode.challanges.binarysearch;
/**
 * Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * https://www.youtube.com/watch?v=nIVW4P8b1VA
 * */
public class FindMinimumInRotatedSortedArraySolution {

    /**
     * Runtime O(logn)
     *
     * */
    public static int findMin(int[] nums) {
        int left =0;
        int right = nums.length -1;

        int min= Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (right + left)/2;
            min = Math.min(min, nums[mid]);

            if (nums[left] <= nums[mid]) {
                if(nums[right] < nums[left]){
                    left = mid+1;
                }else{
                    right = mid -1;
                }
            } else {
                if (nums[right] > nums[left]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }

        return min;
    }

    /**
     * Runtime O(logn)
     *
     * */
    public static int findMinShortAndSweet(int[] nums) {
        int left =0;
        int right = nums.length -1;

        int min= nums[0];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                min = Math.min(min, nums[left]);
            }
            int mid = (left +right)/2;
            min = Math.min(min, nums[mid]);

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return min;
    }
}
