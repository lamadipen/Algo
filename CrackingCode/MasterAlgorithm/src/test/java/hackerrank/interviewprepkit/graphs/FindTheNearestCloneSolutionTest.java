package hackerrank.interviewprepkit.graphs;

import org.junit.Assert;
import org.junit.Test;

public class FindTheNearestCloneSolutionTest {

    @Test
    public void findShortestTest1() {
        int[] graphFrom = new int[]{1, 1, 2, 3};
        int[] graphTo = new int[]{2, 3, 4, 5};
        long[] ids = new long[]{1, 2, 3, 3, 2};
        int shortest = FindTheNearestCloneSolution.findShortestReference(5, graphFrom, graphTo, ids, 2);

        Assert.assertEquals(3, shortest);
    }

    @Test
    public void findShortestTest2() {
        int[] graphFrom = new int[]{1, 1, 4};
        int[] graphTo = new int[]{2, 3, 2};
        long[] ids = new long[]{1, 2, 1, 1};
        int shortest = FindTheNearestCloneSolution.findShortestReference(4, graphFrom, graphTo, ids, 1);

        Assert.assertEquals(1, shortest);
    }
}