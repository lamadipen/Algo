package kata.sortingandsearching.peaksAndValley;

import org.junit.Assert;
import org.junit.Test;

public class PeaksAndValleySolution1Test {

    @Test
    public void peaksAndValleyTest() {
        PeaksAndValleySolution1 peaksAndValleySolution1 = new PeaksAndValleySolution1();

        int[] actual = {9, 7, 8, 4, 0, 1};

        peaksAndValleySolution1.sortPeakValley(actual);
        int[] expected = {1, 0, 7, 4, 9, 8};
        Assert.assertArrayEquals(expected, actual);
    }
}