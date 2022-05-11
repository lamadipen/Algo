package com.leetcode.challanges.two_pointers;

/**
 * Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * */
public class ContainerWithMostWaterSolution {
    /**
     * Runtime O(n^2)
     * Space Complexity O(1)
     * */
    public static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = (j -i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }

        }
        return maxArea;
    }

    /**
     * Runtime O(n)
     * Space Complexity O(1)
     * */
    public static int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
