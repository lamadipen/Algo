package com.leetcode.challanges.binarysearch;

public class SearchInRotatedSortedArraySolution {
/**
 * Runtime O(logn)
 *
 * 2^4 =16
 * log16 = 4
 * */
    public static int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left + right)/2;
            if(target == nums[mid]){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }else{
                if(target > nums[right] || target < nums[mid]){
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            }
        }
        return -1;
    }

}
