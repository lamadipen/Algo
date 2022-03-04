package hackerrank.interviewprepkit.stacksandqueues;


import java.util.Stack;

/**
 * Interview Preparation Kit | Stacks and Queues | Min Max Riddle
 */
public class MinMaxRiddle {

    // Complete the riddle function below.
    static long[] riddle(long[] input) {
        // complete this function
        Stack<Integer> stack = new Stack<>();

        int noOfElement = input.length;

        int[] leftBoundaries = new int[noOfElement];
        int[] rightBoundaries = new int[noOfElement];

        for (int index = 0; index < noOfElement; index++) {
            leftBoundaries[index] = -1;
            rightBoundaries[index] = noOfElement;
        }

        /** what is the index of the first element on my left smaller than me
         * stack is used to determine/calculate window size
         * */
        for (int index = 0; index < noOfElement; index++) {
            while (!stack.isEmpty() && input[stack.peek()] >= input[index]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftBoundaries[index] = stack.peek();
            }
            stack.add(index);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        /** what is the index of the first element on my right smaller than me */
        for (int index = noOfElement - 1; index >= 0; index--) {
            while (!stack.isEmpty() && input[stack.peek()] >= input[index]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightBoundaries[index] = stack.peek();
            }
            stack.add(index);
        }

        long[] results = new long[noOfElement];

        for (int index = 0; index < noOfElement; index++) {
            results[index] = 0;
        }

        for (int index = 0; index < noOfElement; index++) {
            int windowSize = rightBoundaries[index] - leftBoundaries[index] - 2;
            results[windowSize] = Math.max(input[index], results[windowSize]);
        }

        for (int index = noOfElement - 2; index >= 0; index--) {
            results[index] = Math.max(results[index], results[index + 1]);
        }
        return results;
    }
}
