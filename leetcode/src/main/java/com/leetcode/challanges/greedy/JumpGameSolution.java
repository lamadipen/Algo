package com.leetcode.challanges.greedy;
/**
 * Jump Game
 * https://leetcode.com/problems/jump-game/
 *
 * https://www.youtube.com/watch?v=Yan0cv2cLy8
 * */
public class JumpGameSolution {
    /**
     * Runtime O(n)
     * */
    public static boolean canJump(int[] nums) {
        int goal = nums.length -1;

        for (int i = nums.length -2; i >= 0; i--) {
            if(nums[i] + i  >= goal){
                goal = i;
            }
        }
        return  goal == 0;
    }
}
