package hackerrank.interviewprepkit.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumXorSolutionTest {

    @Test
    public void maxXorTest1() {
        int[] actual = MaximumXorSolution.maxXor(new int[]{0, 1, 2}, new int[]{3, 7, 2});

        Assert.assertEquals(3, actual[0]);
        Assert.assertEquals(7, actual[1]);
        Assert.assertEquals(3, actual[2]);
    }

    @Test
    public void maxXorTest2() {
        int[] actual = MaximumXorSolution.maxXor(new int[]{5, 1, 7, 4, 3}, new int[]{2, 0});

        Assert.assertEquals(7, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }

    @Test
    public void maxXorTest3() {
        int[] actual = MaximumXorSolution.maxXor(new int[]{1, 3, 5, 7}, new int[]{17, 6});

        Assert.assertEquals(22, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }

    @Test
    public void maxXorTest4() {
        int[] actual = MaximumXorSolution.maxXor(new int[]{1, 3, 5, 7}, new int[]{17, 6});

        Assert.assertEquals(22, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }

    @Test
    public void maxXorTestOptimized1() {
        int[] actual = MaximumXorSolution.maxXorOptimized(new int[]{0, 1, 2}, new int[]{3, 7, 2});

        Assert.assertEquals(3, actual[0]);
        Assert.assertEquals(7, actual[1]);
        Assert.assertEquals(3, actual[2]);
    }

    @Test
    public void maxXorTestOptimized2() {
        int[] actual = MaximumXorSolution.maxXorOptimized(new int[]{5, 1, 7, 4, 3}, new int[]{2, 0});

        Assert.assertEquals(7, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }

    @Test
    public void maxXorTestOptimized3() {
        int[] actual = MaximumXorSolution.maxXorOptimized(new int[]{1, 3, 5, 7}, new int[]{17, 6});

        Assert.assertEquals(22, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }

    @Test
    public void maxXorTestOptimized4() {
        int[] actual = MaximumXorSolution.maxXorOptimized(new int[]{1, 3, 5, 7}, new int[]{17, 6});

        Assert.assertEquals(22, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }

    @Test
    public void maxXorTestOptimizedTrie4() {
        int[] actual = MaximumXorSolution.maxXorOptimizedWithTries(new int[]{1, 3, 5, 7}, new int[]{17, 6});

        Assert.assertEquals(22, actual[0]);
        Assert.assertEquals(7, actual[1]);
    }
}