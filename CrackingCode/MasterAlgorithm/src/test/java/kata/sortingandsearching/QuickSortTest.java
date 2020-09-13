package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void quickSortTest() {
        QuickSort quickSort = new QuickSort();

        int[] input = new int[]{3, 2, 1, 4};
        quickSort.sort(input);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, input);
    }

}