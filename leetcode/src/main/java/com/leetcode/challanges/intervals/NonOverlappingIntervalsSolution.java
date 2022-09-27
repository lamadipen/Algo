package com.leetcode.challanges.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * https://www.youtube.com/watch?v=nONCGxWoUfM
 */
public class NonOverlappingIntervalsSolution {
    /***
     * Runtime O(nlogn)
     * Depending on sorting algorythm O(n)
     * */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        int intervalsRemoved = 0;
        int[] previous = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            // check if tow interval has intersection
            if (current[0] < previous[1]) {
                intervalsRemoved++;
                // determine which interval to remove
                //remove the interval that ends last
                if (previous[1] > current[1]) {
                    previous = current;
                }
            } else {
                previous = intervals[i];
            }
        }
        return intervalsRemoved;
    }

    public static int eraseOverlapIntervalsRefactored(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        int intervalsRemoved = 0;
        int previousEnd = intervals[0][1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start >= previousEnd) {
                previousEnd = end;
            } else {
                intervalsRemoved++;
                previousEnd = Math.min(end, previousEnd);
            }
        }
        return intervalsRemoved;
    }

}
