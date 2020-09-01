package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void mergeSortTest() {
        MergeSort mergeSort = new MergeSort();

        int[] input = new int[]{3, 2, 1, 4};
        mergeSort.sort(input);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, input);
    }

}