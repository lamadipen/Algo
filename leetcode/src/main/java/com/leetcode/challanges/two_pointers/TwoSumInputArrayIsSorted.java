package com.leetcode.challanges.two_pointers;
/**
 * Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * https://www.youtube.com/embed/cQ1Oz4ckceM
 * */
public class TwoSumInputArrayIsSorted {
    /**
     * Runtime O(n)
     * Space Complexity O(1) if not consider the output array
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length -1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum > target) {
                right--;
            } else if (currentSum < target) {
                left++;
            }else{
                return new int[]{left+1, right+1};
            }
        }
        return new int[0];
    }
}
