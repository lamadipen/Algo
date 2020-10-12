package kata.sortingandsearching.peaksAndValley;

import org.junit.Assert;
import org.junit.Test;

public class PeaksAndValleySolution2Test {

    @Test
    public void peaksAndValleyTest() {
        PeaksAndValleySolution2 peaksAndValleySolution2 = new PeaksAndValleySolution2();

        int[] actual = {9, 7, 8, 4, 0, 1};

        peaksAndValleySolution2.sortPeakValley(actual);
        int[] expected = {7, 9, 4, 8, 0, 1};
        Assert.assertArrayEquals(expected, actual);
    }

}