package com.leetcode.challanges.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * https://leetcode.com/problems/insert-interval/
 * https://www.youtube.com/watch?v=44H3cEC2fFM
 * */
public class InsertIntervalSolution {
    /**
     * Runtime O(n)
     * Space Complexity O(n)
     *
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

    public int[][] insertVersion2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                res.add(interval);
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
