package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PairsWithSumTest {

    @Test
    public void getPairWithSumTest() {
        PairsWithSum pairsWithSum = new PairsWithSum();
        List<Pair> actual = pairsWithSum.getPairWithSum(new int[]{1, 2, 6, 3, 8, 4}, 5);

        Assert.assertEquals(2, actual.size());
    }

    @Test
    public void getPairWithSumAlternateSolutionTest() {
        PairsWithSum pairsWithSum = new PairsWithSum();
        List<Pair> actual = pairsWithSum.getPairWithSumAlternate(new int[]{1, 2, 6, 3, 8, 4}, 5);

        Assert.assertEquals(2, actual.size());
    }
}