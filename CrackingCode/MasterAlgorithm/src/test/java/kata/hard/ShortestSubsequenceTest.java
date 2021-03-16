package kata.hard;

import org.junit.Assert;
import org.junit.Test;

public class ShortestSubsequenceTest {

    @Test
    public void shortestSuperSequence() {
        ShortestSubsequence shortestSubsequence = new ShortestSubsequence();
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};
        Range range = shortestSubsequence.shortestSuperSequence(big, small);

        Assert.assertEquals(7, range.start);
        Assert.assertEquals(10, range.end);
    }

    @Test
    public void shortestSuperSequenceOptimizedTest() {
        ShortestSubsequence shortestSubsequence = new ShortestSubsequence();
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};
        Range range = shortestSubsequence.shortestSuperSequenceOptimized(big, small);

        Assert.assertEquals(7, range.start);
        Assert.assertEquals(10, range.end);
    }

    @Test
    public void shortestSuperSequenceSpaceOptimizedTest() {
        ShortestSubsequence shortestSubsequence = new ShortestSubsequence();
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};
        Range range = shortestSubsequence.shortestSuperSequenceSpaceOptimized(big, small);

        Assert.assertEquals(7, range.start);
        Assert.assertEquals(10, range.end);
    }

    @Test
    public void shortestSuperSequenceClosuerOptimizedTest() {
        ShortestSubsequence shortestSubsequence = new ShortestSubsequence();
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};
        Range range = shortestSubsequence.shortestSuperSequenceClosuerOptimized(big, small);

        Assert.assertEquals(7, range.start);
        Assert.assertEquals(10, range.end);
    }
}