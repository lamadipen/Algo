package com.leetcode.challanges.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * */
public class MergeIntervalsSolution {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(it -> it[0]));

        int[] previous = intervals[0];
        int[] current;

        int[][] result = new int[intervals.length][intervals.length];
        int index =0;
        for (int i = 1; i < intervals.length; i++) {
            current = intervals[i];

            if(current[0] >= previous[1]){
                result[index++] = previous;
                previous = current;
            }else {
                previous[1] = current[1];
            }
        }

        result[index] = previous;

        return result;
    }
}
