package com.leetcode.challanges.heapPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 *  https://www.youtube.com/watch?v=itmhHWaHupI
 */
public class FindMedianFromDataStreamSolution {

    //brings large number on the top (MaxHeap)
    //heap size should be equal or not more than 1 element in either heap
    PriorityQueue<Double> smallHeap;
    //brings small number on the top (MinHeap)
    PriorityQueue<Double> largeHeap;

    public FindMedianFromDataStreamSolution() {
        smallHeap = new PriorityQueue<>();
        largeHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * Runtime O(logn)
     * Space Complexity O(n) where n is number of elements added in the heap
     *
     * */
    public void addNum(Double num) {
        smallHeap.add(num);

        //make sure every number in smallHeap is <= every number in largeHeap
        if (!smallHeap.isEmpty() && !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            Double value = smallHeap.poll();
            largeHeap.add(value);
        }

        //check if the size of smallHeap and largeHeap is uneven
        if (smallHeap.size() > largeHeap.size() + 1) {
            Double value = smallHeap.poll();
            largeHeap.add(value);
        }
        if (largeHeap.size() > smallHeap.size() + 1) {
            Double value = largeHeap.poll();
            smallHeap.add(value);
        }
    }

    /**
     * Runtime O(1) as reading from top of heap is O(1)
     *
     * */
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) {
            return  smallHeap.peek();
        }
        if (largeHeap.size() > smallHeap.size()) {
            return largeHeap.peek();
        }
        return  (largeHeap.peek() + smallHeap.peek())/2;

    }
}
