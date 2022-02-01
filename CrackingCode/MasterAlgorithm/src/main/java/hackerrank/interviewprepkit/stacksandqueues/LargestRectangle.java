package hackerrank.interviewprepkit.stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Interview Preparation Kit | Stacks and Queues | Largest Rectangles
 */
public class LargestRectangle {
    static long maxArea = Integer.MIN_VALUE;

    public static long largestRectangle(List<Integer> input) {
        // Write your code here

//        2 1 2
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int area = 0;
        int i;

        for (i = 0; i < input.size(); ) {
            if (stack.isEmpty() || input.get(stack.peekFirst()) <= input.get(i)) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = input.get(top) * i;
                } else {
                    area = input.get(top) * (i - stack.peekFirst() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pollFirst();

            if (stack.isEmpty()) {
                area = input.get(top) * i;
            } else {
                area = input.get(top) * (i - stack.peekFirst() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
