package hackerrank.interviewprepkit.sorting;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortCountingInversionsTest {

    @Test
    public void countInversions1() {
        int[] integers = new int[]{2, 1, 3, 1, 2};
        long result = MergeSortCountingInversions.countInversions(integers);
        Assert.assertEquals(4, result);
    }

    @Test
    public void countInversions2() {
        int[] integers = new int[]{2, 4, 1};
        long result = MergeSortCountingInversions.countInversions(integers);
        Assert.assertEquals(2, result);
    }
}