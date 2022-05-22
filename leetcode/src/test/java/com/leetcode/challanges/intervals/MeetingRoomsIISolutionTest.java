package com.leetcode.challanges.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsIISolutionTest {

    @Test
    void minMeetingRoomsTest1() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        intervals.add(new Interval(0, 30));
        int actual = MeetingRoomsIISolution.minMeetingRooms(intervals);
        Assertions.assertEquals(2,actual);
    }


    @Test
    void minMeetingRoomsTest2() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(9, 15));
        int actual = MeetingRoomsIISolution.minMeetingRooms(intervals);
        Assertions.assertEquals(2,actual);
    }
}