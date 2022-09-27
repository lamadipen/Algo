package com.leetcode.challanges.intervals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Meeting Rooms
 * https://www.lintcode.com/problem/920/
 *
 * https://www.youtube.com/watch?v=PaJxqZVPhbg
 * */
public class MeetingRoomsSolution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     *
     * Runtime O(nlogn)
     * Space complexity O(1) if we don't consider sorting took any space.
     */
    public static boolean canAttendMeetingsUsingSorting(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return false;
        intervals.sort(Comparator.comparing(item -> item.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval meeting1 = intervals.get(i - 1);
            Interval meeting2 = intervals.get(i);

            if (meeting1.end > meeting2.start) {
                return false;
            }
        }
        return true;
    }
}
