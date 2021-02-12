package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void findMajorityElementTest() {
        MajorityElement majorityElement = new MajorityElement();
        int[] array = new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5};
        int actual = majorityElement.findMajorityElement(array);
        Assert.assertEquals(5, actual);

        int[] array2 = new int[]{1, 2, 5, 9, 1, 1, 1};
        int actual1 = majorityElement.findMajorityElement(array2);
        Assert.assertEquals(1, actual1);
    }

    @Test
    public void findMajorityElementOptimizedTest() {
        MajorityElement majorityElement = new MajorityElement();
        int[] array = new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5};
        int actual = majorityElement.findMajorityElementOptimized(array);
        Assert.assertEquals(5, actual);

        int[] array2 = new int[]{1, 2, 5, 9, 1, 1, 1};
        int actual1 = majorityElement.findMajorityElementOptimized(array2);
        Assert.assertEquals(1, actual1);
    }
}