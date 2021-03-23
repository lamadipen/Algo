package kata.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContiniousMedianSolution {
    PriorityQueue<Integer> minHeap, maxHeap;

    public ContiniousMedianSolution() {
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        this.maxHeap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        ;
    }

    public void addRandomNumbers(int number) {
        if (minHeap.size() == maxHeap.size()) {
            if (minHeap.peek() != null && number > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(number);
            } else {
                maxHeap.offer(number);
            }
        } else {
            if (maxHeap.peek() > number) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(number);
            } else {
                minHeap.offer(number);
            }
        }
    }

    public int findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return minHeap.peek();
        }
    }
}
