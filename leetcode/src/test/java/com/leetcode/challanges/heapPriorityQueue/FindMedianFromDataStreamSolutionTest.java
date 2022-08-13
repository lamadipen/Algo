package com.leetcode.challanges.heapPriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianFromDataStreamSolutionTest {

    @Test
    void findMedianTest1() {
        FindMedianFromDataStreamSolution obj = new FindMedianFromDataStreamSolution();
        obj.addNum(1.0);
        obj.addNum(2.0);
        double actual1 = obj.findMedian();
        Assertions.assertEquals(1.5,actual1);
        obj.addNum(3.0);
        double actual2 = obj.findMedian();
        Assertions.assertEquals(2,actual2);

    }

}