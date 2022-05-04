package com.leetcode.challanges.arrays_hashing;

import java.util.*;

/**
 * Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElementsSolution {

    /**
     * Runtime O(n + n+ n ) => O(n) where n is the input size
     * Space Complexity O(n)
     * */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num,count+1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if (entry.getValue() >= k) {
                result.add(entry.getKey());
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

}
