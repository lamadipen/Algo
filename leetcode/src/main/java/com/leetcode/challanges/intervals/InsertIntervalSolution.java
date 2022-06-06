package com.leetcode.challanges.intervals;
/**
 * Insert Interval
 * https://leetcode.com/problems/insert-interval/
 *
 * */
public class InsertIntervalSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(n)
     * */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int [][] merged = new int[intervals.length+1][intervals[0].length];
        if (intervals.length < 2) {
            return intervals;
        }
        int intervalTracker =0;
        int index =0;

        while (intervalTracker < intervals.length && intervals[intervalTracker][1] < newInterval[0]){
            merged[index++] = intervals[intervalTracker++];
        }

        while (intervalTracker < intervals.length && intervals[intervalTracker][0] < newInterval[1]){
            newInterval[0] = Math.min(intervals[intervalTracker][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[intervalTracker][1], newInterval[1]);
            intervalTracker++;
        }

        merged[index++] = newInterval;

        while (intervalTracker < intervals.length) {
            merged[index++] = intervals[intervalTracker++];
        }
        return merged;
    }
}
