package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class ContiguousSequenceTest {
    @Test
    public void getContiguousMaxSum() {
        ContiguousSequence contiguousSequence = new ContiguousSequence();
        int contiguousMaxSum = contiguousSequence.getContiguousMaxSum(new int[]{2, -8, 3, -2, 4, -10});
        Assert.assertEquals(5, contiguousMaxSum);

        ContiguousSequence contiguousSequence1 = new ContiguousSequence();
        int contiguousMaxSum1 = contiguousSequence.getContiguousMaxSum(new int[]{-2, -8, -3, -2, -4, -10});
        Assert.assertEquals(0, contiguousMaxSum1);
    }

}