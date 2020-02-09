package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Find Numbers with Even Number of Digits
 * <p>
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * <p>
 * Example 2:
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 **/
public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int value : nums) {
            int temp = (int) (Math.log10(value) + 1);
            if(isEven(temp)){
                evenCount++;
            }
        }
        return evenCount;
    }

    private boolean isEven(int v) {
        if(v%2 == 0) return true;
        return false;
    }

    @Test
    public void findNumbersTest() {
        Assert.assertEquals(2, findNumbers(new int[]{12, 345, 2, 6, 7896}));
        Assert.assertEquals(1, findNumbers(new int[]{555, 901, 482, 1771}));
    }
}
