package hackerrank.interviewprepkit.stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinMaxRiddleTest {

    /**
     * https://www.youtube.com/watch?v=MJzZgHFc00U not that good but can be reference
     * Approaching to the soultion
     * Window size 1
     * {2}, {6}, {1}, {12} => Max 12
     * <p>
     * Window size 2
     * {2,6}, {6,1}, {1,12} => min {2, 1, 1} => max 2
     * <p>
     * window size 3
     * {2,6,1} ,{6,1,12}  => min {1,1} => max 1
     * <p>
     * window size 4
     * {2,6,1,12} => min 1  => max 1
     * <p>
     * Final Answer
     * {12, 2 , 1, ,1}
     * <p>
     * steps while calculating the window size and max min
     * input 	[2, 6, 1,12]
     * left 	[-1,0,-1, 2]  what is the index of the first element on my left smaller than me use stack to navigate and maintain array
     * right 	[2, 2, 4, 4]  what is the index of the first element on my right smaller than me  use stack to navigate and maintain array
     * WSize    1, 0, 3 ,0  right[index] - left[index] -2 (we need -2 for 2 reasons, -1 as we are taking input length on right which will cause index out of bound error and -1 to adjust the result (index) in the array)
     * result  [0, 0, 0, 0] initilize result array
     * result  [12, 2, 1, 0] loop through input & apply result[WSize] = Max of input[index] or result[WSize]
     * result  [12, 2, 1, 0] (length of Input - 2)reverse loop Max of result[index] or result[index +1]
     */
    @Test
    public void riddle() {
        long[] arr = new long[]{2, 6, 1, 12};
        long[] actual = MinMaxRiddle.riddle(arr);
        assertArrayEquals(new long[]{12, 2, 1, 1}, actual);
    }

}