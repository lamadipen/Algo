package com.dp.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * **/
public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i){
                return new int[]{i, map.get(compliment)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void twoSumTest(){
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result);
        Assert.assertEquals(0,result[0]);
        Assert.assertEquals(1,result[1]);
    }

    public int[] twoSumOnePass(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if (map.containsKey(compliment) && map.get(compliment) != i) {
                return new int[]{i,map.get(compliment)};
            }
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }


}
