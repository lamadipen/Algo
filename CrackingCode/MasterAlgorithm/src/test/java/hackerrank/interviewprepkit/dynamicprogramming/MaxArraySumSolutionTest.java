package hackerrank.interviewprepkit.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class MaxArraySumSolutionTest {

    @Test
    public void maxSubsetSumTest1() {
        int[] arr = {3, 7, 4, 6, 5};
        int actual = MaxArraySumSolution.maxSubsetSum(arr);
        Assert.assertEquals(13, actual);
    }

    @Test
    public void maxSubsetSumTest2() {
        int[] arr = {2, 1, 5, 8, 4};
        int actual = MaxArraySumSolution.maxSubsetSum(arr);
        Assert.assertEquals(11, actual);
    }

    @Test
    public void maxSubsetSumTest3() {
        int[] arr = {3, 5, -7, 8, 10};
        int actual = MaxArraySumSolution.maxSubsetSum(arr);
        Assert.assertEquals(15, actual);
    }
}