package hackerrank.interviewprepkit.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MarkAndToysTest {

    @Test
    public void maximumToysTest() {
        List<Integer> prices = Arrays.asList(1, 12, 5, 111, 200, 1000, 10);
        int maxToys = MarkAndToys.maximumToys(prices, 50);
        Assert.assertEquals(4, maxToys);
    }

}