package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedArrayTest {

    @Test
    public void searchTest() {
        int expected = 8;
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();

        int[] arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        int actual = searchInRotatedArray.find(arr, 5);

        Assert.assertEquals(expected, actual);
    }

}