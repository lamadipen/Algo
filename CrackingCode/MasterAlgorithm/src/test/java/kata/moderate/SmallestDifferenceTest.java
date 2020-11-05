package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class SmallestDifferenceTest {

    @Test
    public void getSmallestDifferenceBruteForceTest() {
        SmallestDifference smallestDifference = new SmallestDifference();
        int[] arr1 = {1, 3, 15, 11, 2};
        int[] arr2 = {23, 127, 235, 19, 8};
        Pair actual = smallestDifference.getSmallestDifferenceBruteForce(arr1, arr2);

        Assert.assertNotNull(actual);
        Assert.assertEquals(11, actual.x);
        Assert.assertEquals(8, actual.y);
    }

    @Test
    public void getSmallestDifferenceTest() {
        SmallestDifference smallestDifference = new SmallestDifference();
        int[] arr1 = {1, 3, 15, 11, 2};
        int[] arr2 = {23, 127, 235, 19, 8};
        Pair actual = smallestDifference.getSmallestDifferenceBruteForce(arr1, arr2);

        Assert.assertNotNull(actual);
        Assert.assertEquals(11, actual.x);
        Assert.assertEquals(8, actual.y);
    }
}