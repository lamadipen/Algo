package com.leetcode.challanges.intervals;

import java.util.*;

/**
 * Minimum Interval to Include Each Query
 * https://leetcode.com/problems/minimum-interval-to-include-each-query/
 * */
public class MinimumIntervalToIncludeEachQuerySolution {
/**
 * Runtime 0(nlogn + qlogq) where n is size of interval and q is size of the queries
 * Space Complexity O(q)
 * */
    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparing(it -> it[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(it-> it[0]));
        Map<Integer, int[]> result = new HashMap();

        int[] queriesClone = queries.clone();
        Arrays.sort(queriesClone);
        int index =0;
        for (int query:queriesClone) {
            while (index < intervals.length && intervals[index][0] <= query) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                int intervalSize = right - left + 1;
                minHeap.add(new int[]{intervalSize, right});
                index++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query){
                    minHeap.remove();
            }

            result.put(query, minHeap.peek());
        }

        int[] finalResult = new int[queries.length];
        int pointer =0;
        for (int query:queries) {
            int[] orDefault = result.get(query);
            finalResult[pointer++] = orDefault == null ? -1: orDefault[0];
        }
        return finalResult;
    }
}
