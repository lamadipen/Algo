package kata.sortingandsearching.rankfromstream;

import org.junit.Assert;
import org.junit.Test;

public class RankFromStreamSolutionTest {

    @Test
    public void getRankTest() {
        RankFromStreamSolution rankFromStreamSolution = new RankFromStreamSolution();

        rankFromStreamSolution.track(20);
        rankFromStreamSolution.track(15);
        rankFromStreamSolution.track(25);
        rankFromStreamSolution.track(10);
        rankFromStreamSolution.track(5);
        rankFromStreamSolution.track(13);
        rankFromStreamSolution.track(23);
        rankFromStreamSolution.track(24);

        int actual = rankFromStreamSolution.getRank(20);

        Assert.assertEquals(4, actual);
        int actual1 = rankFromStreamSolution.getRank(25);
        Assert.assertEquals(7, actual1);

        int actual2 = rankFromStreamSolution.getRank(24);
        Assert.assertEquals(6, actual2);
    }
}