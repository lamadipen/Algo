package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void binarySearchRecursiveTest() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int actual = binarySearch.binarySearchRecursive(input, 2);
        Assert.assertEquals(1, actual);

        int actual1 = binarySearch.binarySearchRecursive(input, 9);
        Assert.assertEquals(8, actual1);

        int actual2 = binarySearch.binarySearchRecursive(input, 0);
        Assert.assertEquals(-1, actual2);

        int actual3 = binarySearch.binarySearchRecursive(input, 10);
        Assert.assertEquals(-1, actual3);
    }

    @Test
    public void binarySearchIterativeTest() {
        BinarySearch binarySearch = new BinarySearch();

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int actual = binarySearch.binarySearchIterative(input, 1);
        Assert.assertEquals(0, actual);

        int actual1 = binarySearch.binarySearchIterative(input, 9);
        Assert.assertEquals(8, actual1);

        int actual2 = binarySearch.binarySearchIterative(input, 0);
        Assert.assertEquals(-1, actual2);

        int actual3 = binarySearch.binarySearchIterative(input, 10);
        Assert.assertEquals(-1, actual3);
    }

}