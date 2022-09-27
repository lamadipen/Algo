package com.leetcode.challanges.intervals;

import java.util.Arrays;
import java.util.List;

/**
 * Meeting Rooms II
 * https://www.lintcode.com/problem/919/
 *
 * https://www.youtube.com/watch?v=FdzJmTCVyJU
 *
 * */
public class MeetingRoomsIISolution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     *
     * Runtime O(nlogn)
     * Space Complexity O(n)
     */
    public static int minMeetingRooms(List<Interval> intervals) {
        int[] startTime = new int[intervals.size()];
        int[] endTime = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            startTime[i] = interval.start;
            endTime[i] = interval.end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int minMeetingRooms =0;
        int countMeetingRooms =0;
        int startIndex =0;
        int endIndex =0;

        while (startIndex < intervals.size()) {
            if (startTime[startIndex] < endTime[endIndex]) {
                countMeetingRooms++;
                startIndex++;
            }else{
                countMeetingRooms--;
                endIndex++;
            }
            minMeetingRooms = Math.max(minMeetingRooms, countMeetingRooms);
        }
        return countMeetingRooms;
    }
}
