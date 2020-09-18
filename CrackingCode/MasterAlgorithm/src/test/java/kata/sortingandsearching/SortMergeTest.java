package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortMergeTest {

    @Test
    public void sortMergerTest() {
        SortMerge sortMerge = new SortMerge();

        int[] aArr = new int[]{2, 3, 5, 6, 0, 0, 0, 0};
        int[] bArr = new int[]{1, 4, 8, 10};
        sortMerge.sortMerger(aArr, bArr);
        System.err.println(Arrays.toString(aArr));

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 8, 10}, aArr);
    }
}