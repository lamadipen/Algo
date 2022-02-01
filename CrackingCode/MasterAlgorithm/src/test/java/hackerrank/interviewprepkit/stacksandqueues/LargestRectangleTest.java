package hackerrank.interviewprepkit.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LargestRectangleTest {

    @Test
    public void largestRectangleTest1() {
        List<Integer> h = Arrays.asList(1, 2, 3, 4, 5);
        long actual = LargestRectangle.largestRectangle(h);
        Assert.assertEquals(9, actual);
    }

    @Test
    public void largestRectangleTest2() {
        List<Integer> h = Arrays.asList(1, 3, 5, 9, 11);
        long actual = LargestRectangle.largestRectangle(h);
        Assert.assertEquals(18, actual);
    }

    @Test
    public void largestRectangleTest3() {
        List<Integer> h = Arrays.asList(11, 11, 10, 10, 10);
        long actual = LargestRectangle.largestRectangle(h);
        Assert.assertEquals(50, actual);
    }


    @Test
    public void largestRectangleTest4() {
        List<Integer> h = Arrays.asList(3, 2, 5, 6, 1, 4, 4);
        long actual = LargestRectangle.largestRectangle(h);
        Assert.assertEquals(10, actual);
    }

    @Test
    public void largestRectangleTest5() {
        List<Integer> h = Arrays.asList(1, 2, 4, 3);
        long actual = LargestRectangle.largestRectangle(h);
        Assert.assertEquals(6, actual);
    }
}