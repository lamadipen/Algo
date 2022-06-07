package com.leetcode.challanges.binarysearch;

public class BinarySearchSolution {

    /** Runtime O(logn)
     *  Runtime O(logn)
     * */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid + 1;
            } else {
                left = mid - 1;
            }
        }
        return -1;
    }



    /** Runtime O(logn)
     *  Runtime O(logn)
     * */
    public static int searchRecursive(int[] nums, int target) {
       return bSearchRecursive(nums,target,0, nums.length);
    }

    public static int bSearchRecursive(int[] nums, int target, int start, int end){
        int mid =((end - start)/2) + start;
        if (target == nums[mid]) {
            return mid;
        }else if(end - start ==1){
            return -1;
        }else if (target < nums[mid]) {
            return bSearchRecursive(nums, target, start, mid);
        } else {
            return bSearchRecursive(nums, target, mid, end);
        }
    }
}
